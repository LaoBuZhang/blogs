package cn.itcast.hotel.service.impl;

import cn.itcast.hotel.mapper.HotelMapper;
import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.pojo.PageResult;
import cn.itcast.hotel.pojo.RequestParams;
import cn.itcast.hotel.service.IHotelService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 查询
     */
    @Override
    public PageResult search(RequestParams params) {
        try {
            //1.准备requset
            SearchRequest request = new SearchRequest("hotel");

            //2.准备DSL
            //query
            buildBasicQuery(params, request);
            //分页
            int page = params.getPage();
            int size = params.getSize();
            request.source().from((page-1)*size).size(size);
            //排序
            String location = params.getLocation();
            if(location!=null&&!location.equals("")){
                request.source().sort(SortBuilders
                        .geoDistanceSort("location",new GeoPoint(location))
                        .order(SortOrder.ASC)
                        .unit(DistanceUnit.KILOMETERS)
                );
            }

            //3.发送请求
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            //4.解析响应
            return handleResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void buildBasicQuery(RequestParams params, SearchRequest request) {
        //1.构建BoolQuery
        BoolQueryBuilder boolQuery=QueryBuilders.boolQuery();
        //关键字搜索
        String key = params.getKey();
        if(key==null||"".equals(key)){
            boolQuery.must(QueryBuilders.matchAllQuery());
        }else{
            boolQuery.must(QueryBuilders.matchQuery("all",key));
        }
        //城市条件
        String city = params.getCity();
        if(city!=null&&!"".equals(city)){
            boolQuery.filter(QueryBuilders.termQuery("city",city));
        }
        //品牌条件
        String brand = params.getBrand();
        if(brand!=null&&!"".equals(brand)){
            boolQuery.filter(QueryBuilders.termQuery("brand",brand));
        }
        //星级条件
        String starName = params.getStarName();
        if(starName!=null&&!"".equals(starName)){
            boolQuery.filter(QueryBuilders.termQuery("starName",starName));
        }
        //价格条件
        Integer maxPrice = params.getMaxPrice();
        Integer minPrice = params.getMinPrice();
        if(maxPrice!=null&&minPrice!=null){
            boolQuery.filter(QueryBuilders
                    .rangeQuery("price").gte(minPrice).lte(maxPrice));
        }

        //2.算分控制
        FunctionScoreQueryBuilder functionScoreQuery =
                QueryBuilders.functionScoreQuery(
                        //原始查询，相关性算分查询
                        boolQuery,
                        //function score数组
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                                //其中的一个function score元素
                                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                                        //过滤条件
                                        QueryBuilders.termQuery("isAD",true),
                                        //算分函数
                                        ScoreFunctionBuilders.weightFactorFunction(10)
                                )
                        });

        //放入source
        request.source().query(functionScoreQuery);
    }

    private PageResult handleResponse(SearchResponse response) {
        //4.解析响应
        SearchHits searchHits = response.getHits();
        //4.1.获取总条数
        long total=searchHits.getTotalHits().value;
        //4.2.文档数组
        SearchHit[] hits = searchHits.getHits();
        //4.3.遍历
        List<HotelDoc> hotels=new ArrayList<>();
        for(SearchHit hit:hits){
            //获取文档source
            String json=hit.getSourceAsString();
            //反序列化
            HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);

            //获取排序值
            Object[] sortValues = hit.getSortValues();
            if(sortValues.length>0){
                Object sortValue=sortValues[0];
                hotelDoc.setDistance(sortValue);
            }
            hotels.add(hotelDoc);
        }
        return new PageResult(total,hotels);
    }


    /**
     * 聚合
     */
    @Override
    public Map<String, List<String>> filters(RequestParams params) {
        try {
            //1.准备Request
            SearchRequest request=new SearchRequest("hotel");
            // 2.准备DSL
            //2.1.query
            buildBasicQuery(params,request);
            //2.2.设置size
            request.source().size(0);
            //2.3.聚合
            buildAggregation(request);
            //3.发送请求
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            //4.解析结果
            Aggregations aggregations=response.getAggregations();
            Map<String,List<String>>result=new HashMap<>();
            //4.1.根据名称获取结果
            List<String> brandList = getAggByName(aggregations,"brandAgg");
            result.put("brand",brandList);
            List<String> cityList = getAggByName(aggregations,"cityAgg");
            result.put("city",cityList);
            List<String> starList = getAggByName(aggregations,"starAgg");
            result.put("starName",starList);

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private List<String> getAggByName(Aggregations aggregations,String aggName) {
        // 4.1.根据聚合名称获取聚合结果
        Terms brandAgg= aggregations.get(aggName);
        // 4.2.获取buckets
        List<? extends Terms.Bucket> buckets = brandAgg.getBuckets();
        // 4.3.遍历
        List<String>brandList=new ArrayList<>();
        for(Terms.Bucket bucket:buckets){
            // 4.4.获取key
            String key = bucket.getKeyAsString();
            brandList.add(key);
        }
        return brandList;
    }

    //聚合条件封装的方法，优雅
    private void buildAggregation(SearchRequest request) {
        request.source().aggregation(AggregationBuilders
                .terms("brandAgg")
                .field("brand")
                .size(100)
        );
        request.source().aggregation(AggregationBuilders
                .terms("cityAgg")
                .field("city")
                .size(100)
        );
        request.source().aggregation(AggregationBuilders
                .terms("starAgg")
                .field("starName.keyword")
                .size(100)
        );
    }



    /**
     * 自动补全
     */
    @Override
    public List<String> getSuggestions(String prefix) {
        try {
            // 1.准备Request
            SearchRequest request = new SearchRequest("hotel");
            // 2.准备DSL
            request.source().suggest(new SuggestBuilder().addSuggestion(
                    "suggestion",
                    SuggestBuilders.completionSuggestion("suggestion")
                            .prefix(prefix)
                            .skipDuplicates(true)
                            .size(10)
            ));
            // 3.发起请求
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            // 4.解析结果
            Suggest suggest = response.getSuggest();
            // 4.1.根据补全查询名称，获取补全结果
            CompletionSuggestion suggestions = suggest.getSuggestion("suggestion");
            // 4.2.获取options
            List<CompletionSuggestion.Entry.Option> options = suggestions.getOptions();
            // 4.3.遍历
            List<String> list = new ArrayList<>(options.size());
            for (CompletionSuggestion.Entry.Option option : options) {
                String text = option.getText().toString();
                list.add(text);
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * 酒店删除业务
     * @param id 酒店id
     */
    @Override
    public void deleteById(Long id) {
        try {
            //1.准备Request
            DeleteRequest request = new DeleteRequest("hotel",id.toString());
            //2.准备发送请求
            client.delete(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 酒店新增或修改业务
     * @param id 酒店id
     */
    @Override
    public void insertById(Long id) {
        try {
            //0.根据id查询酒店数据
            Hotel hotel=getById(id);
            //0.转换为文档类型
            HotelDoc hotelDoc=new HotelDoc(hotel);
            //1.准备Request
            IndexRequest request = new IndexRequest("hotel").id(hotel.getId().toString());
            //2.准备DSL
            request.source(JSON.toJSONString((hotelDoc)), XContentType.JSON);
            //3.发送请求
            client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
