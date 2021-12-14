package com.gaogg.wxmp.contorller;

import com.gaogg.wxmp.dao.GetIndexDao;
import com.gaogg.wxmp.domain.*;
import com.gaogg.wxmp.result.ReIndexClassify;
import com.gaogg.wxmp.result.ReIndexGoods;
import com.gaogg.wxmp.result.ReIndexSwiper;
import com.gaogg.wxmp.result.ReStuts;
import com.gaogg.wxmp.util.ReStutsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/index")
public class GetIndexData {
    @Autowired
    GetIndexDao getIndexDao;

    @Autowired
    ReStutsUtil reStutsUtil;
    /**
     * 滚动图片
     * @return
     */
    @RequestMapping(value = "/swipers")
    public ReIndexSwiper getIndexSwiper(){
        ReIndexSwiper reIndexSwiper = new ReIndexSwiper();
        List<WXIndexSwiper> indexSwipers = getIndexDao.getIndexSwipers();
        reIndexSwiper.setLists(indexSwipers);
        ReStuts reStuts=reStutsUtil.getReStuts(indexSwipers.size());
        reIndexSwiper.setReStuts(reStuts);
        return reIndexSwiper;
    }

    /**
     * 获取分类图片
     * @return
     */
    @RequestMapping(value = "/classify")
    public ReIndexClassify getIndexClassify(){
        ReIndexClassify reIndexClassify = new ReIndexClassify();
        List<WXIndexClassifys> indexClassifys = getIndexDao.getIndexClassifys();
        reIndexClassify.setWxIndexClassifys(indexClassifys);
        ReStuts reStuts=reStutsUtil.getReStuts(indexClassifys.size());
        reIndexClassify.setReStuts(reStuts);
        return reIndexClassify;
    }

    /**
     * 获取栏目图
     * @return
     */
    @RequestMapping(value = "/goods")
    public ReIndexGoods contextLoads() {
        List<WXIndexColumns> indexColumns = getIndexDao.getIndexColumns();
        List<WXIndexGoods> wxIndexGoods=new ArrayList<>();
        for (WXIndexColumns indexColumn : indexColumns) {
            //System.out.println(indexColumn);
            WXIndexGoods wxIndexGoods1 = new WXIndexGoods();
            wxIndexGoods1.setWxIndexColumns(indexColumn);
            List<WXIndexColumnDatas> datasWithcolumnNum = getIndexDao.getDatasWithcolumnNum(indexColumn.getColumnNum());
            wxIndexGoods1.setLists(datasWithcolumnNum);
            wxIndexGoods.add(wxIndexGoods1);
        }
        ReIndexGoods reIndexGoods = new ReIndexGoods();
        reIndexGoods.setWxIndexGoods(wxIndexGoods);
        ReStuts reStuts=reStutsUtil.getReStuts(wxIndexGoods.size());
        reIndexGoods.setReStuts(reStuts);
        return reIndexGoods;
    }


}
