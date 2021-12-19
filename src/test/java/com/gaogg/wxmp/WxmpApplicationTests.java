package com.gaogg.wxmp;

import com.gaogg.wxmp.contorller.GetClassifyData;
import com.gaogg.wxmp.dao.GetClassifyDao;
import com.gaogg.wxmp.dao.GetIndexDao;
import com.gaogg.wxmp.domain.*;
import com.gaogg.wxmp.service.GetGoodsLists;
import com.gaogg.wxmp.util.PageHelperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void contextLoads() {
        getClassifyData.getClassifyNoId();
    }

    @Test
    public void testgoods(){
        final PageHelperUtil<GoodsList> goodsByPages = getGoodsLists.getGoodsByPage("", 5, 1,1, 10);
        System.out.println(goodsByPages);
    }
}
