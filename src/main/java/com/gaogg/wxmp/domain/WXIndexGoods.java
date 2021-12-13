package com.gaogg.wxmp.domain;

import lombok.Data;

import java.util.List;

@Data
public class WXIndexGoods {
    private WXIndexColumns wxIndexColumns;
    private List<WXIndexColumnDatas> lists;
}
