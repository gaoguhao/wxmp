package com.gaogg.wxmp.dao;

import com.gaogg.wxmp.domain.WXOneLanClassify;
import com.gaogg.wxmp.domain.WXThreeLanClassify;
import com.gaogg.wxmp.domain.WXTwoLanClassify;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GetClassifyDao {
    @Select("select * from oneLanClassify")
    List<WXOneLanClassify> getOneLanClassify();

    @Select("select * from threeLanClassify where middle_cat_id=#{cat_id}")
    List<WXThreeLanClassify> getThreeLanClassify(int cat_id);

    @Select("select id, big_cat_id,cat_id,cat_name,cat_pid,cat_level,cat_deleted,cat_icon from twoLanClassify where big_cat_id=#{big_cat_id}")
    @Results({
            /*
            * - property = “children”, 表示要将返回的查询结果赋值给WXTwoLanClassify的children属性
            * - column = “cat_id” 是指将WXTwoLanClassify的cat_id作为com.gaogg.wxmp.dao.GetClassifyDao.getThreeLanClassify的查询参数
            * */
            @Result(property = "children", column="cat_id",
                    many = @Many(select = "com.gaogg.wxmp.dao.GetClassifyDao.getThreeLanClassify"))
    })
    List<WXTwoLanClassify> getAllLanClassifys(int big_cat_id);
}
