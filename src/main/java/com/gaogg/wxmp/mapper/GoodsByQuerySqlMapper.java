package com.gaogg.wxmp.mapper;
//商品获取动态判断sql生成文件
public class GoodsByQuerySqlMapper {
    public String selectByQuery(String query,int catId,int orders){
        StringBuffer sql = new StringBuffer("select goods_id,cat_id,goods_name,goods_price,goods_number,goods_weight,goods_big_logo,add_time,upd_time,hot_mumber,is_promote,cat_one_id,cat_two_id,cat_three_id from goodsList where goods_price>0");
        if(catId!=0){
            sql.append(" and cat_id=#{catId}");
        }
        if (!("".equals(query))) {
            sql.append(" and goods_name Like '%" + query + "%'");
        }
        if(orders==1){
            sql.append(" order by hot_mumber DESC");
        }else if(orders==2){
            sql.append(" order by goods_price DESC");
        }else{
            sql.append(" order by upd_time DESC");
        }
        return sql.toString();
    }
}
