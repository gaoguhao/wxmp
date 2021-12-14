package com.gaogg.wxmp.domain;

import lombok.Data;

@Data
public class WXOneLanClassify {
    private int id;
    private int cat_id;
    private String cat_name;
    private int cat_pid;
    private int cat_level;
    private Boolean cat_deleted;
    private String cat_icon;

}
