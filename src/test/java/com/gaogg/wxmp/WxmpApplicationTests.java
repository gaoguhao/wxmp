package com.gaogg.wxmp;

import com.gaogg.wxmp.contorller.GetClassifyData;
import com.gaogg.wxmp.dao.GetClassifyDao;
import com.gaogg.wxmp.dao.GetIndexDao;
import com.gaogg.wxmp.domain.*;
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

    @Test
    void contextLoads() {
        getClassifyData.getClassifyNoId();
    }

}
