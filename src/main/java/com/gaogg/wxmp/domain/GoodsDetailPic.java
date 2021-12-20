package com.gaogg.wxmp.domain;

import lombok.Data;

@Data
public class GoodsDetailPic {
    private Long id;
    private Long pics_id;
    private Long goods_id;
    private String pics_big;
    private String pics_mid;
    private String pics_sma;
    private String pics_big_url;
    private String pics_mid_url;
    private String pics_sma_url;
}
