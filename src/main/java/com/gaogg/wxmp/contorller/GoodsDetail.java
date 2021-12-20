package com.gaogg.wxmp.contorller;

import com.gaogg.wxmp.dao.GetGoodsDetailDao;
import com.gaogg.wxmp.domain.GoodsDetails;
import com.gaogg.wxmp.result.ReStuts;
import com.gaogg.wxmp.result.ResultRecode;
import com.gaogg.wxmp.util.ReStutsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/goodsDetail")
public class GoodsDetail {
    @Autowired
    GetGoodsDetailDao getGoodsDetailDao;
    @Autowired
    ReStutsUtil reStutsUtil;

    @RequestMapping("/dataById")
    public ResultRecode<GoodsDetails> getGoodsDetailDataById(@RequestParam(name = "id",defaultValue = "0")Long id){
        final GoodsDetails goodsDetail = getGoodsDetailDao.getGoodsDetail(id);
        final ResultRecode<GoodsDetails> goodsDetailsResultRecode = new ResultRecode<>();
        goodsDetailsResultRecode.setDatas(goodsDetail);
        final ReStuts reStuts = reStutsUtil.getReStuts(goodsDetail.getGoods_name().length());
        goodsDetailsResultRecode.setReStuts(reStuts);
        return goodsDetailsResultRecode;
    }

    @RequestMapping("/updateById")
    public ResultRecode<Integer> updateDetailsBysId(@RequestParam(name = "id",defaultValue = "0")Long id,@RequestParam(name="promote",defaultValue = "false") String promote){
        final ResultRecode<Integer> integerResultRecode = new ResultRecode<>();
        final int i = getGoodsDetailDao.changeGoodsDetailById(id, promote);
        integerResultRecode.setReStuts(reStutsUtil.getReStuts(i));
        integerResultRecode.setDatas(i);
        return integerResultRecode;
    }
}
