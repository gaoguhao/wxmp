package com.gaogg.wxmp.mapper;
//商品获取动态判断sql生成文件
public class GoodsByQuerySqlMapper {
    public String selectByQuery(String query,int catId){
        StringBuffer sql = new StringBuffer("select goods_id,cat_id,goods_name,goods_price,goods_number,goods_weight,goods_big_logo,add_time,upd_time,hot_mumber,is_promote,cat_one_id,cat_two_id,cat_three_id from goodsList");
        if(catId!=0){
            if(sql.equals("where")){
                sql.append(" and cat_id=#{catId}");
            }else{
                sql.append(" where cat_id=#{catId}");
            }

        }
        if (!("".equals(query))) {
            if(sql.equals("where")){
                sql.append(" AND goods_name Like '%" + query + "%'");
            }else{
                sql.append(" where goods_name Like '%" + query + "%'");
            }

        }
        return sql.toString();
    }
}
