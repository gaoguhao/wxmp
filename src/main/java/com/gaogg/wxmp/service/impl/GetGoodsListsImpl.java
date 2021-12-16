package com.gaogg.wxmp.service.impl;

import com.gaogg.wxmp.dao.QueryGoodsLists;
import com.gaogg.wxmp.domain.GoodsList;
import com.gaogg.wxmp.service.GetGoodsLists;
import com.gaogg.wxmp.util.PageHelperUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetGoodsListsImpl implements GetGoodsLists {
    @Autowired
    private QueryGoodsLists queryGoodsLists;

    @Override
    public PageHelperUtil<GoodsList> getGoodsByPage(String query, int catId, Integer pagenum, Integer pagesize) {
//        设置起始以及每页显示数
        PageHelper.startPage(pagenum,pagesize);
        //查询数据
        List<GoodsList> goodsLists= queryGoodsLists.queryGoodsByCatId(query,catId);
        //将查询结果交给pageInfo处理
        PageInfo<GoodsList> pageInfo=new PageInfo<>(goodsLists);
        //创建封装结果集对象
        PageHelperUtil<GoodsList> listPageHelperUtil=new PageHelperUtil<>();
        //当前页面
        listPageHelperUtil.setPagenum(pagenum);
        //每页查询数
        listPageHelperUtil.setPagesize(pagesize);
        //总条数
        listPageHelperUtil.setTotal(pageInfo.getTotal());
        //总页数
        listPageHelperUtil.setPageTotal(pageInfo.getPages());
        //结果集数据
        listPageHelperUtil.setList(pageInfo.getList());

        return listPageHelperUtil;
    }
}
