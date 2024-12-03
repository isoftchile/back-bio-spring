package com.sys.bio.back.cut.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MonthlyWeightDto {

    private int month;
    private long currentYearWeight;
    private long previousYearWeight;
    
}
