package com.sys.bio.back.repositories.cutting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sys.bio.back.cut.domain.models.CutType;

import java.util.List;
import java.util.Optional;

public interface CutTypeRepository extends JpaRepository<CutType, Long> {

    @Query("SELECT c.cutTypeId FROM CutType c")
    List<Long> findAllIds();

    Optional<CutType> findByName(String name);
}
