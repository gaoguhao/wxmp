package com.gaogg.wxmp.util;

import lombok.Data;

import java.util.List;

@Data
public class PageHelperUtil<T> {
//    共有数据
    private long total;
//    共有页数
    private Integer pageTotal;
//    当前页
    private Integer pagenum;
//    每页显示条数
    private Integer pagesize;
//      结果集
    private List<T> list;
}
