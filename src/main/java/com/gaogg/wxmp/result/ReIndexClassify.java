package com.gaogg.wxmp.result;

import com.gaogg.wxmp.domain.WXIndexClassifys;
import lombok.Data;

import java.util.List;
@Data
public class ReIndexClassify {
    private List<WXIndexClassifys> wxIndexClassifys;
    private ReStuts reStuts;
}
