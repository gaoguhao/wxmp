package com.gaogg.wxmp.result;

import com.gaogg.wxmp.domain.WXIndexSwiper;
import lombok.Data;

import java.util.List;

@Data
public class ReIndexSwiper {
    private ReStuts reStuts;
    private List<WXIndexSwiper> lists;
}
