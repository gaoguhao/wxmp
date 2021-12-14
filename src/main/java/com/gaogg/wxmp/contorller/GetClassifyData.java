package com.gaogg.wxmp.contorller;

import com.gaogg.wxmp.dao.GetClassifyDao;
import com.gaogg.wxmp.domain.WXOneLanClassify;
import com.gaogg.wxmp.domain.WXTwoLanClassify;
import com.gaogg.wxmp.result.ReClassifys;
import com.gaogg.wxmp.result.ReOneClassify;
import com.gaogg.wxmp.result.ReStuts;
import com.gaogg.wxmp.util.ReStutsUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/classify")
public class GetClassifyData {

    @Autowired
    GetClassifyDao classifyDao;
    @Autowired
    ReStutsUtil reStutsUtil;
    /**
     * 滚动图片
     * @return
     */
    @RequestMapping("/oneLanClassify")
    public ReOneClassify getIndexSwiper(){
        ReOneClassify reOneClassify=new ReOneClassify();
        List<WXOneLanClassify> oneLanClassifys = classifyDao.getOneLanClassify();
        reOneClassify.setWxOneLanClassifyList(oneLanClassifys);
        ReStuts reStuts = reStutsUtil.getReStuts(oneLanClassifys.size());
        reOneClassify.setReStuts(reStuts);
        return reOneClassify;
    }

    /**
     * 通过栏目id获取栏目信息
     * @param big_cat_id    栏目id
     * @return
     */
    @RequestMapping(value = "/getClassifybyId")
    public ReClassifys getClassifybyId(@RequestParam(value = "id",defaultValue = "0") int big_cat_id){
        ReClassifys reClassifys=new ReClassifys();
        if(big_cat_id==0){
            reClassifys = getClassifyNoId();
        }else{
            List<WXTwoLanClassify> allLanClassifys= classifyDao.getAllLanClassifys(big_cat_id);
            reClassifys.setWxTwoLanClassifies(allLanClassifys);
            ReStuts reStuts = reStutsUtil.getReStuts(allLanClassifys.size());
            reClassifys.setReStuts(reStuts);
        }

        return reClassifys;
    }

    public ReClassifys getClassifyNoId(){
        ReClassifys reClassifys=new ReClassifys();
        List<WXTwoLanClassify> allLanClassifys=null;
        List wxTwoLanClassifys=new ArrayList();
        List<WXOneLanClassify> oneLanClassifys = classifyDao.getOneLanClassify();
        for (WXOneLanClassify oneLanClassify : oneLanClassifys) {
            allLanClassifys = classifyDao.getAllLanClassifys(oneLanClassify.getCat_id());
            wxTwoLanClassifys.add(allLanClassifys);
        }

        reClassifys.setWxTwoLanClassifies(wxTwoLanClassifys);
        ReStuts reStuts = reStutsUtil.getReStuts(wxTwoLanClassifys.size());
        reClassifys.setReStuts(reStuts);
        return reClassifys;
    }
}
