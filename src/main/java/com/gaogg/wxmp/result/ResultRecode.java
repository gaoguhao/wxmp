package com.gaogg.wxmp.result;

import lombok.Data;

import java.util.List;
@Data
public class ResultRecode<T> {
    //通用返回数据类型
    ReStuts reStuts;
    T datas;
}
