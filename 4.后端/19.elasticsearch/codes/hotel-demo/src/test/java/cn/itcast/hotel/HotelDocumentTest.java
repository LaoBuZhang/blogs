package cn.itcast.hotel;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.IHotelService;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static cn.itcast.hotel.constants.HotelConstants.MAPPING_TEMPLATE;

@SpringBootTest
public class HotelDocumentTest {

    @Autowired
    private IHotelService hotelService;

    private RestHighLevelClient client;

    /**
     * 添加文档
     */
    @Test
    void testAddDocument() throws IOException {
        Hotel hotel = hotelService.getById(61083L);

        HotelDoc hotelDoc = new HotelDoc(hotel);

        //1.准备request对象
        IndexRequest request = new IndexRequest("hotel").id(hotelDoc.getId().toString());
        //2.准备json文档
        request.source(JSON.toJSONString(hotelDoc),XContentType.JSON);
        //3.发送请求
        client.index(request,RequestOptions.DEFAULT);
    }

    /**
     * 查询文档
     */
    @Test
    void testGetDocument() throws IOException {
        //1.准备request
        GetRequest request = new GetRequest("hotel", "61083");
        //2.发送请求，得到响应
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        //3.解析响应结果
        String json = response.getSourceAsString();

        HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);
        System.out.println(hotelDoc);
    }

    /**
     * 修改文档
     */
    @Test
    void testUpdateDocument() throws IOException {
        //1.准备request
        UpdateRequest request = new UpdateRequest("hotel","61083");
        //2.准备请求参数
        request.doc(
                "price", "952",
                "starName", "四钻"
        );
        //3.发送请求
        client.update(request,RequestOptions.DEFAULT);
    }

    /**
     * 删除文档
     */
    @Test
    void testDeleteDocument() throws IOException {
        //1.准备request
        DeleteRequest request = new DeleteRequest("hotel","61083");
        //2.发送请求
        client.delete(request,RequestOptions.DEFAULT);
    }

    /**
     * 批量处理
     */
    @Test
    void testBulkDocument() throws IOException {
        // 批量查询酒店数据
        List<Hotel>hotels=hotelService.list();

        //1.准备request
        BulkRequest request = new BulkRequest();
        // 2.准备参数，添加多个新增的Request
        for(Hotel hotel:hotels){
            // 2.1.转换为文档类型HotelDoc
            HotelDoc hotelDoc=new HotelDoc(hotel);
            // 2.2.创建新增文档的Request对象
            request.add(
                    new IndexRequest("hotel")
                            .id(hotelDoc.getId().toString())
                            .source(JSON.toJSONString(hotelDoc),XContentType.JSON)
            );
        }
        // 3.发送请求
        client.bulk(request,RequestOptions.DEFAULT);
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
