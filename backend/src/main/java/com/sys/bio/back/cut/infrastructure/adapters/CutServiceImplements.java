package com.sys.bio.back.cut.infrastructure.adapters;

import java.time.Year;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.bio.back.cut.app.out.CutRepository;
import com.sys.bio.back.cut.app.ports.services.CutService;
import com.sys.bio.back.cut.domain.models.Cutting;
import com.sys.bio.back.cut.infrastructure.dto.MonthlyWeightDto;
import com.sys.bio.back.models.dto.ResponsibleHoursSumDTO;
import com.sys.bio.back.models.user.Responsible;
import com.sys.bio.back.repositories.user.ResponsibleRepository;

@Service
public class CutServiceImplements implements CutService {

    @Autowired
    private CutRepository cutRepository;

    @Autowired
    private ResponsibleRepository responsibleRepository;

    @Override
    public Cutting addCutting(Cutting cutting) {
        return cutRepository.save(cutting);
    }

    @Override
    public Cutting updateCutting(Cutting cutting) {
        return cutRepository.save(cutting);
    }

    @Override
    public Set<Cutting> getCuttings() {
        return new LinkedHashSet<>(cutRepository.findAll());
    }

    @Override
    public Cutting getCutting(Long cuttingId) {
        return cutRepository.findById(cuttingId).get();
    }

    @Override
    public void deleteCutting(Long cuttingId) {
        Cutting cutting = new Cutting();
        cutting.setCuttingId(cuttingId);
        cutRepository.delete(cutting);
    }

    @Override
    public List<Cutting> getCuttingsByDateRange(Date startDate, Date endDate) {
        return cutRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public List<Cutting> searchByResponsibleName(String name) {
        if (name != null) {
            return cutRepository.findByResponsibleNameContainingIgnoreCase(name);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<ResponsibleHoursSumDTO> getTotalHoursByResponsibleForLastMonth() {
        List<Object[]> results = cutRepository.findTotalHoursByResponsibleLastMonth();
        return results.stream()
                .map(result -> {
                    Long responsibleId = (Long) result[0];
                    Integer totalHours = ((Number) result[1]).intValue();
                    Responsible responsible = responsibleRepository.findById(responsibleId).orElse(null);
                    assert responsible != null;
                    return new ResponsibleHoursSumDTO(responsible.getName(), totalHours);
                })
                .collect(Collectors.toList());
    }

    /* 
    @Transactional(readOnly = true)
    public List<MonthlyCutStats> getCurrentYearStats() {
        return cuttingRepository.findMonthlyStatsByCurrentYear(Year.now().getValue());
    }*/

    @Override
    public List<MonthlyWeightDto> getMonthlyWeightsForCurrentAndPreviousYear() {
        return cutRepository.findMonthlyTotalWeights();
    }


}
