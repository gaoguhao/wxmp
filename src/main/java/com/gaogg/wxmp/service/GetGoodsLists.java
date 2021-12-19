package com.gaogg.wxmp.service;


import com.gaogg.wxmp.domain.GoodsList;
import com.gaogg.wxmp.util.PageHelperUtil;

public interface GetGoodsLists {
    PageHelperUtil<GoodsList> getGoodsByPage(String query,int catId,int orders,Integer pagenum,Integer pagesize);
}
