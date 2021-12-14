package com.gaogg.wxmp.util;

import com.gaogg.wxmp.result.ReStuts;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class ReStutsUtil {
    /**
     * 状态回值封装
     * @param listLength
     * @return
     */
    public ReStuts getReStuts(int listLength) {
        ReStuts reStuts = new ReStuts();
        if(listLength>0){
            reStuts.setRecode(1);
            reStuts.setMsg("获取成功");
        }else{
            reStuts.setRecode(0);
            reStuts.setMsg("获取失败");
        }
        return reStuts;
    }
}
