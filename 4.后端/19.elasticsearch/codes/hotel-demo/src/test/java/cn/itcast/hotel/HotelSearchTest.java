package cn.itcast.hotel;

import cn.itcast.hotel.pojo.HotelDoc;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class HotelSearchTest {

    private RestHighLevelClient client;


    /**
     * 查询所有
     */
    @Test
    void testMatchAll() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.matchAllQuery());
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }


    /**
     * match查询
     */
    @Test
    void testMatch() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.matchQuery("all","如家"));
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }


    /**
     * term查询
     */
    @Test
    void testTerm() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.termQuery("city","上海"));
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }


    /**
     * range查询
     */
    @Test
    void testRange() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.rangeQuery("price").gte(100).lte(150));
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }


    /**
     * bool查询
     */
    @Test
    void testBool() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        //2.1.准备BoolQuery
        BoolQueryBuilder boolQuery=QueryBuilders.boolQuery();
        //2.2.添加term
        boolQuery.must(QueryBuilders.termQuery("city","上海"));
        //2.3.添加range
        boolQuery.filter(QueryBuilders.rangeQuery("price").lte(250));
        request.source().query(boolQuery);
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }

    /**
     * 排序和分页
     */
    @Test
    void testPageAndSort() throws IOException {
        int page = 1, size = 5;
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.matchAllQuery());
        request.source().from((page-1)*size).size(size);
        request.source().sort("price", SortOrder.ASC);
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }

    /**
     * 高亮
     */
    @Test
    void testHighlight() throws IOException {
        int page = 1, size = 5;
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().query(QueryBuilders.matchQuery("all","如家"));
        request.source().highlighter(new HighlightBuilder().field("name").requireFieldMatch(false));
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        handleResponse(response);
    }

    /**
     * 聚合查询
     */
    @Test
    void testAggregation() throws IOException {
        //1.准备requset
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().size(0);
        request.source().aggregation(AggregationBuilders
                .terms("brandAgg")
                .field("brand")
                .size(20)
        );
        //3.发送请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析响应
        Aggregations aggregations = response.getAggregations();
        //4.1.根据聚合名称获取聚合结果
        Terms brandTerms=aggregations.get("brandAgg");
        //4.2.获取buckets
        List<? extends Terms.Bucket> buckets = brandTerms.getBuckets();
        //4.3.遍历
        for(Terms.Bucket bucket:buckets){
            //4.3.获取key和doc_count
            String key = bucket.getKeyAsString();
            long count = bucket.getDocCount();
            System.out.println(count+"家"+key);
        }
    }



    private void handleResponse(SearchResponse response) {
        //4.解析响应
        SearchHits searchHits = response.getHits();
        //4.1.获取总条数
        long total=searchHits.getTotalHits().value;
        System.out.println("共搜索到"+total+"条数据");
        //4.2.文档数组
        SearchHit[] hits = searchHits.getHits();
        //4.3.遍历
        for(SearchHit hit:hits){
            String json=hit.getSourceAsString();
            //反序列化
            HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);

            //获取高亮结果
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if(!CollectionUtils.isEmpty(highlightFields)){
                //根据名字获取高亮结果
                HighlightField highlightField = highlightFields.get("name");
                if(highlightField!=null){
                    //获取高亮值
                    String name = highlightField.getFragments()[0].string();
                    //覆盖肥膏粱结果
                    hotelDoc.setName(name);
                }
            }

            //输出结果
            System.out.println("hotelDoc="+hotelDoc);
        }
    }


    /**
     * 自动补全
     */
    @Test
    void testSuggestion() throws IOException {
        //1.准备request
        SearchRequest request = new SearchRequest("hotel");
        //2.准备DSL
        request.source().suggest(new SuggestBuilder().addSuggestion(
                "suggestion",
                SuggestBuilders.completionSuggestion("suggestion")
                        .prefix("h")
                        .skipDuplicates(true)
                        .size(10)
        ));
        //3.发起请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.解析结果

        Suggest suggest = response.getSuggest();

        //4.1.根据补全查询名称获取补全结果
        CompletionSuggestion suggestions = suggest.getSuggestion("suggestion");

        //4.2.获取options
        List<CompletionSuggestion.Entry.Option> options = suggestions.getOptions();
        //4.3.遍历
        for (CompletionSuggestion.Entry.Option option : options) {
            String text = option.getText().toString();
            System.out.println(text);
        }
    }


    @BeforeEach
    void setUp(){
        this.client=new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.234.100:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }
}
