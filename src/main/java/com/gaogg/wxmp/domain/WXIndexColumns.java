package com.gaogg.wxmp.domain;

import lombok.Data;

import java.util.List;

@Data
public class WXIndexColumns {
    private String columnName;
    private int columnNum;
    private String image_src;
    private int modeId;
//    private List<WXIndexColumnDatas> indexColumnDatas;
}
