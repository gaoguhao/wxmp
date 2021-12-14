package com.gaogg.wxmp.result;

import com.gaogg.wxmp.domain.WXOneLanClassify;
import lombok.Data;

import java.util.List;

@Data
public class ReOneClassify {
    private List<WXOneLanClassify> wxOneLanClassifyList;
    private ReStuts reStuts;
}
