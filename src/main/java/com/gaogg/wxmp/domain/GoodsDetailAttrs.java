package com.gaogg.wxmp.domain;

import lombok.Data;

@Data
public class GoodsDetailAttrs {
    private Long id;
    private Long goods_id;
    private Long attr_id;
    private String attr_value;
    private Long add_price;
    private String attr_name;
    private String attr_sel;
    private String attr_write;
    private String attr_vals;
}
