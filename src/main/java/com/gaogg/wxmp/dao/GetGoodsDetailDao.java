package com.gaogg.wxmp.dao;

import com.gaogg.wxmp.domain.GoodsDetailAttrs;
import com.gaogg.wxmp.domain.GoodsDetailPic;
import com.gaogg.wxmp.domain.GoodsDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GetGoodsDetailDao {
    @Select("select * from goodsDetailPic where goods_id=#{goods_id}")
    List<GoodsDetailPic> getGoodsDetailPicById(Long goods_id);

    @Select("select * from goodsDetailAttrs where goods_id=#{goods_id}")
    List<GoodsDetailAttrs> getGoodsDetailAttrsById(Long goods_id);

    //查询所有内容页面数据
    @Select("select * from goodsDetailOne where goods_id=#{goods_id}")
    @Results({
            @Result(property="pics",column = "goods_id",many = @Many(select = "com.gaogg.wxmp.dao.GetGoodsDetailDao.getGoodsDetailPicById")),
            @Result(property = "attrs",column = "goods_id",many = @Many(select = "com.gaogg.wxmp.dao.GetGoodsDetailDao.getGoodsDetailAttrsById"))
    })
    GoodsDetails getGoodsDetail(Long goods_id);

    //更新收藏
    @Update("update goodsDetailOne set is_promote=#{is_promote} where goods_id=#{goods_id}")
    int changeGoodsDetailById(Long goods_id,String is_promote);
}
