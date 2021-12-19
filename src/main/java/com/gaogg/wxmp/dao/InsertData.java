package com.gaogg.wxmp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertData {
    @Insert("insert into goodsDetailOne ('goods_id','cat_id' ,'goods_name','goods_price' ,'goods_number','goods_weight','goods_introduce','goods_big_logo','goods_small_logo','goods_state' ,'is_del','add_time' ,'upd_time','delete_time','hot_mumber','is_promote','cat_one_id' ,'cat_two_id','cat_three_id','goods_cat') VALUES(#{goods_id},#{cat_id},#{goods_name},#{goods_price},#{goods_number},#{goods_weight},#{goods_introduce},#{goods_big_logo},#{goods_small_logo},#{goods_state},#{is_del},#{add_time},#{upd_time},#{delete_time},#{hot_mumber},#{is_promote},#{cat_one_id},#{cat_two_id},#{cat_three_id},#{goods_cat})")
    int insertIntoGoodsDetailOne(Long goods_id, Long cat_id, String goods_name, Long goods_price , Long goods_number, Long goods_weight, String goods_introduce, String goods_big_logo, String goods_small_logo, Long goods_state , Long is_del, String add_time , String upd_time, String delete_time, Long hot_mumber, String is_promote, Long cat_one_id , Long cat_two_id, Long cat_three_id, String goods_cat);

    @Insert("insert into goodsDetailPic ('pics_id','goods_id', 'pics_big','pics_mid','pics_sma', 'pics_big_url', 'pics_mid_url', 'pics_sma_url')VALUES(#{pics_id},#{goods_id},#{pics_big},#{pics_mid},#{pics_sma},#{ pics_big_url},#{pics_mid_url},#{pics_sma_url})")
    int insertGoodsPic(Long pics_id,Long goods_id,String pics_big,String pics_mid,String pics_sma,String pics_big_url,String pics_mid_url,String pics_sma_url);

    @Insert("insert into goodsDetailAttrs('goods_id','attr_id', 'attr_value', 'add_price','attr_name','attr_sel','attr_write','attr_vals')VALUES(#{goods_id},#{attr_id},#{attr_value},#{add_price},#{attr_name},#{attr_sel},#{attr_write},#{attr_vals})")
    int goodsDetailAttrs(Long pics_id,Long goods_id,String pics_big,String pics_mid,String pics_sma,String pics_big_url,String pics_mid_url,String pics_sma_url);
}
