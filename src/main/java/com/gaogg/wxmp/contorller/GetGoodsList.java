package com.gaogg.wxmp.contorller;

import com.gaogg.wxmp.domain.GoodsList;
import com.gaogg.wxmp.result.ReStuts;
import com.gaogg.wxmp.result.ResultRecode;
import com.gaogg.wxmp.service.GetGoodsLists;
import com.gaogg.wxmp.util.PageHelperUtil;
import com.gaogg.wxmp.util.ReStutsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/goodsList")
public class GetGoodsList {
    @Autowired
    GetGoodsLists getGoodsLists;
    @Autowired
    ReStutsUtil reStutsUtil;

    @RequestMapping(value = "/query")
    public ResultRecode<PageHelperUtil> getGoodsByCatIdOrName(@RequestParam(name = "query",defaultValue = "") String query,
                                              @RequestParam(name = "id",defaultValue = "0") int catId,
                                              @RequestParam(name = "pagenum",defaultValue = "1") Integer pagenum,
                                              @RequestParam(name = "pagesize",defaultValue = "8") Integer pagesize){
        PageHelperUtil<GoodsList> goodsByPage = getGoodsLists.getGoodsByPage(query, catId, pagenum, pagesize);
        ResultRecode<PageHelperUtil> goodsListResultRecode = new ResultRecode<>();
        ReStuts reStuts = reStutsUtil.getReStuts(goodsByPage.getList().size());
        goodsListResultRecode.setDatas(goodsByPage);
        goodsListResultRecode.setReStuts(reStuts);
        return goodsListResultRecode;
    }
}
