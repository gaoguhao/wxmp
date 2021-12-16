package com.gaogg.wxmp.domain;

import lombok.Data;

@Data
public class GoodsList {
    private long goods_id;
    private int cat_id;
    private String goods_name;
    private long goods_price;
    private int goods_number;
    private long goods_weight;
    private String goods_big_logo;
    private String add_time;
    private String upd_time;
    private int hot_mumber;
    private String is_promote;
    private int cat_one_id;
    private int cat_two_id;
    private int cat_three_id;
}
