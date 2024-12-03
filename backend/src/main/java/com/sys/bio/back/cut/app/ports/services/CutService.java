package com.sys.bio.back.cut.app.ports.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sys.bio.back.cut.domain.models.Cutting;
import com.sys.bio.back.cut.infrastructure.dto.MonthlyWeightDto;
import com.sys.bio.back.models.dto.ResponsibleHoursSumDTO;

public interface CutService {

    Cutting addCutting(Cutting cutting);
    Cutting updateCutting(Cutting cutting);
    Set<Cutting> getCuttings();
    Cutting getCutting(Long cuttingId);
    void deleteCutting(Long cuttingId);
    List<Cutting> getCuttingsByDateRange(Date startDate, Date endDate);
    List<Cutting> searchByResponsibleName(String name);
    List<ResponsibleHoursSumDTO> getTotalHoursByResponsibleForLastMonth();
    List<MonthlyWeightDto> getMonthlyWeightsForCurrentAndPreviousYear();

}
