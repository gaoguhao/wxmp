package com.gaogg.wxmp.result;

import com.gaogg.wxmp.domain.WXOneLanClassify;
import com.gaogg.wxmp.domain.WXTwoLanClassify;
import lombok.Data;

import java.util.List;

@Data
public class ReClassifys {
    private List<WXTwoLanClassify> wxTwoLanClassifies;
    private ReStuts reStuts;
}
