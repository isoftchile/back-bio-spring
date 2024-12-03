package com.sys.bio.back.cut.app.out;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sys.bio.back.cut.domain.models.Cutting;
import com.sys.bio.back.cut.infrastructure.dto.MonthlyWeightDto;


public interface CutRepository extends JpaRepository<Cutting, Long>,
        JpaSpecificationExecutor<Cutting> {

    @Query
    ("SELECT c.cuttingId FROM Cutting c")
    List<Long> findAllIds();

    List<Cutting> findByDateBetween(Date startDate, Date endDate);

    List<Cutting> findByResponsibleNameContainingIgnoreCase(String name);

    @Query("SELECT c.responsible.responsibleId, SUM(c.totalHours)" +
            "FROM Cutting c " +
            "WHERE FUNCTION('YEAR', c.date) = FUNCTION('YEAR', CURRENT_DATE) " +
            "AND FUNCTION('MONTH', c.date) = FUNCTION('MONTH', CURRENT_DATE) - 1 " +
            "GROUP BY c.responsible.responsibleId")
    List<Object[]> findTotalHoursByResponsibleLastMonth();


    @Query("SELECT new com.sys.bio.back.cut.infrastructure.dto.MonthlyWeightDto(" +
            "MONTH(c.date), " +
            "SUM(CASE WHEN YEAR(c.date) = YEAR(CURRENT_DATE) THEN c.totalWeight ELSE 0 END), " +
            "SUM(CASE WHEN YEAR(c.date) = YEAR(CURRENT_DATE) -1 THEN c.totalWeight ELSE 0 END)) " +
            "FROM Cutting c " +
            "GROUP BY MONTH(c.date)")
        List<MonthlyWeightDto> findMonthlyTotalWeights();
}
