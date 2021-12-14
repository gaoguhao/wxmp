package com.gaogg.wxmp;

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

    @Test
    void contextLoads() {
        final List<WXOneLanClassify> oneLanClassifys = getClassifyDao.getOneLanClassify();
        for (WXOneLanClassify oneLanClassify : oneLanClassifys) {
            //System.out.println(oneLanClassify);
            final List<WXTwoLanClassify> allLanClassifys = getClassifyDao.getAllLanClassifys(oneLanClassify.getCat_id());
            for (WXTwoLanClassify allLanClassify : allLanClassifys) {
                System.out.println(allLanClassify);
            }
        }
    }

}
