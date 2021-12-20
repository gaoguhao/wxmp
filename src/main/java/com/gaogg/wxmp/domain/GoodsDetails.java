package com.gaogg.wxmp.domain;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDetails {
    private Long id;
    private Long goods_id;
    private Long cat_id;
    private String goods_name;
    private Long goods_price ;
    private Long goods_number;
    private Long goods_weight;
    private String goods_introduce;
    private String goods_big_logo;
    private String goods_small_logo;
    private Long goods_state;
    private String is_del;
    private Long add_time;
    private Long upd_time;
    private String delete_time;
    private Long hot_mumber;
    private Boolean is_promote;
    private Long cat_one_id;
    private Long cat_two_id;
    private Long cat_three_id;
    private String goods_cat;
    private List<GoodsDetailPic> pics;
    private List<GoodsDetailAttrs> attrs;
}
