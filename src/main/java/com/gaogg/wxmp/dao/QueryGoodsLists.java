package com.gaogg.wxmp.dao;

import com.gaogg.wxmp.domain.GoodsList;
import com.gaogg.wxmp.mapper.GoodsByQuerySqlMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface QueryGoodsLists {
    @Select("select goods_id,cat_id,goods_name,goods_price,goods_number,goods_weight,goods_big_logo,add_time,upd_time,hot_mumber,is_promote,cat_one_id,cat_two_id,cat_three_id from goodsList")
    List<GoodsList> queryAll();
    //通过mapper.class方式来生成sql文件typ表示类方法，method标识调用的哪个执行方法
    @SelectProvider(type= GoodsByQuerySqlMapper.class,method = "selectByQuery")
    List<GoodsList> queryGoodsByCatId(String query,int catId);
}
