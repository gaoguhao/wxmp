package com.gaogg.wxmp;

import com.gaogg.wxmp.dao.GetIndexDao;
import com.gaogg.wxmp.domain.WXIndexColumnDatas;
import com.gaogg.wxmp.domain.WXIndexColumns;
import com.gaogg.wxmp.domain.WXIndexGoods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WxmpApplicationTests {
    @Autowired
    GetIndexDao getIndexDao;

    @Test
    void contextLoads() {

//        final List<WXIndexColumns> goodsWithColumn = getIndexDao.getGoodsWithColumn();
//        for (WXIndexColumns wxIndexGoods : goodsWithColumn) {
//            System.out.println(wxIndexGoods.getColumnNum());
//        }
        final List<WXIndexColumns> indexColumns = getIndexDao.getIndexColumns();
        List<WXIndexGoods> wxIndexGoods=new ArrayList<>();
        for (WXIndexColumns indexColumn : indexColumns) {
            System.out.println(indexColumn);
            final WXIndexGoods wxIndexGoods1 = new WXIndexGoods();
            wxIndexGoods1.setWxIndexColumns(indexColumn);
            final List<WXIndexColumnDatas> datasWithcolumnNum = getIndexDao.getDatasWithcolumnNum(indexColumn.getColumnNum());
            wxIndexGoods1.setLists(datasWithcolumnNum);
            wxIndexGoods.add(wxIndexGoods1);
        }
    }

}
