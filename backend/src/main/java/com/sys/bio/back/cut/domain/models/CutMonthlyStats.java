package com.sys.bio.back.cut.domain.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CutMonthlyStats {
    int month;
    int totalMini;
    int totalStandard;
    int totalBiggy;
}
