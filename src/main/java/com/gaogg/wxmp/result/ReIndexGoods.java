package com.gaogg.wxmp.result;

import com.gaogg.wxmp.domain.WXIndexGoods;
import lombok.Data;

import java.util.List;

@Data
public class ReIndexGoods {
    private List<WXIndexGoods> wxIndexGoods;
    private ReStuts reStuts;
}
