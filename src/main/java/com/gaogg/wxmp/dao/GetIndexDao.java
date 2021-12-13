package com.gaogg.wxmp.dao;

import com.gaogg.wxmp.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GetIndexDao {
    /**
     * 获取滚动图
     * @return
     */
    @Select({"select image_src,open_type,goods_id,navigator_url from indexSwipers"})
    List<WXIndexSwiper> getIndexSwipers();

    /**
     * 获取中间分类导航
     * @return
     */
    @Select("select name,image_src,open_type,navigator_url from indexClassifys")
    List<WXIndexClassifys> getIndexClassifys();

    /**
     * 通过栏目分类获取栏目数据
     * @param columnNum 栏目编号
     * @return
     */
    @Select("select name,image_src,images_width,open_type,navigator_url,columnNum from indexColumnDatas where columnNum=#{columnNum}")
    List<WXIndexColumnDatas> getDatasWithcolumnNum(int columnNum);

    /**
     * 获取所有栏目
     * @return
     */
    @Select("select columnName,columnNum,image_src from indexColumn ")
    List<WXIndexColumns> getIndexColumns();

    /**
     * 一对多获取栏目
     * 获取所有栏目及数据
     * @return
     */
    @Select("select columnName,columnNum,image_src from indexColumn ")
    @Results({
            @Result(property = "indexColumnDatas", column="columnNum",
                many = @Many(select = "com.gaogg.wxmp.dao.GetIndexDao.getDatasWithcolumnNum"))
    })
    List<WXIndexColumnsOneTOMany> getGoodsWithColumn();
}
