package com.gaogg.wxmp;


import com.gaogg.wxmp.contorller.GetClassifyData;
import com.gaogg.wxmp.dao.GetClassifyDao;
import com.gaogg.wxmp.dao.GetIndexDao;
import com.gaogg.wxmp.dao.InsertData;
import com.gaogg.wxmp.dao.QueryGoodsLists;
import com.gaogg.wxmp.domain.*;
import com.gaogg.wxmp.service.GetGoodsLists;
import com.gaogg.wxmp.util.PageHelperUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WxmpApplicationTests {
    @Autowired
    GetClassifyDao getClassifyDao;
    @Autowired
    GetClassifyData getClassifyData;

    @Autowired
    GetGoodsLists getGoodsLists;

    @Autowired
    InsertData insertData;
    @Autowired
    QueryGoodsLists queryGoodsLists;

    @Test
    void contextLoads() {
        getClassifyData.getClassifyNoId();
    }

    @Test
    public void testgoods(){
        final PageHelperUtil<GoodsList> goodsByPages = getGoodsLists.getGoodsByPage("", 5, 1,1, 10);
        System.out.println(goodsByPages);
    }

    @Test
    public void doGet() throws InterruptedException {
        // 声明 http get 请求
        final List<Long> goodsLists = queryGoodsLists.queryGoodsId();
        //System.out.println(goodsLists);
        String url="";
        for (Long goodsList : goodsLists) {
            url="https://api-hmugo-web.itheima.net/api/public/v1/goods/detail?goods_id=";
            url=url+goodsList;
            //System.out.println(url);
            insertDatas(url);
            //Thread.sleep(3000);
        }
       // insertDatas(url);
        //String url="https://api-hmugo-web.itheima.net/api/public/v1/goods/detail?goods_id=43986";

    }

    private void insertDatas(String url) {
        String result = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                final JSONObject parse = (JSONObject) new JSONParser().parse(result);
                final JSONObject jsonObject = (JSONObject) parse.get("message");
//                isNulls(jsonObject,"delete_time");
//                System.out.println(jsonObject.get("goods_introduce").toString().toCharArray().length);
 //               System.out.println(jsonObject.get("goods_introduce").getClass().toString());
//                System.out.println(jsonObject.get("goods_cat").getClass().toString());

                insertData.insertIntoGoodsDetailOne(
                        (Long)jsonObject.get("goods_id"),
                        (Long)jsonObject.get("cat_id"),
                        (String)jsonObject.get("goods_name"),
                        (Long)jsonObject.get("goods_price"),
                        (Long)jsonObject.get("goods_number"),
                        (Long)jsonObject.get("goods_weight"),
                        (String)jsonObject.get("goods_introduce"),
                        (String)jsonObject.get("goods_big_logo"),
                        (String)jsonObject.get("goods_small_logo"),
                        (Long)jsonObject.get("goods_state"),
                        (String)jsonObject.get("is_del"),
                        (Long)jsonObject.get("add_time"),
                        (Long)jsonObject.get("upd_time"),
                        (String)jsonObject.get("delete_time"),
                        (Long)jsonObject.get("hot_mumber"),
                        (Boolean)jsonObject.get("is_promote"),
                        (Long)jsonObject.get("cat_one_id"),
                        (Long)jsonObject.get("cat_two_id"),
                        (Long)jsonObject.get("cat_three_id"),
                        (String)jsonObject.get("goods_cat"));
                final JSONArray pics = (JSONArray) jsonObject.get("pics");
                System.out.println(pics.size());
                for(int i=0;i<pics.size();i++){
                    JSONObject pic = (JSONObject)  pics.get(i);
                    //System.out.println(pic.get("pics_mid"));
                    insertData.insertGoodsPic(
                            (Long)pic.get("pics_id"),
                            (Long)pic.get("goods_id"),
                            (String)pic.get("pics_big"),
                            (String)pic.get("pics_mid"),
                            (String)pic.get("pics_sma"),
                            (String)pic.get("pics_big_url"),
                            (String)pic.get("pics_mid_url"),
                            (String)pic.get("pics_sma_url"));
                }

                final JSONArray attrs = (JSONArray) jsonObject.get("attrs");
                //System.out.println(pics.size());
                for(int j=0;j<attrs.size();j++){
                    JSONObject attr = (JSONObject) attrs.get(j);
                    //System.out.println(pic.get("pics_mid"));
                    insertData.insertGoodsDetailAttrs(
                            (Long)attr.get("goods_id"),
                            (Long)attr.get("attr_id"),
                            (String)attr.get("attr_value"),
                            (Long)attr.get("add_price"),
                            (String)attr.get("attr_name"),
                            (String)attr.get("attr_sel"),
                            (String)attr.get("attr_write"),
                            (String)attr.get("attr_vals"));
                }
            }
            //Thread.sleep(000);
            //System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
