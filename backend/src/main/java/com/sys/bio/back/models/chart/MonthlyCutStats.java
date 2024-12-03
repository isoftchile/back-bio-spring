package com.sys.bio.back.models.chart;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MonthlyCutStats {
    int month;
    int totalMini;
    int totalStandard;
    int totalBiggy;
}
