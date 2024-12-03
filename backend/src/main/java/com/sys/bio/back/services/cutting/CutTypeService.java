package com.sys.bio.back.services.cutting;

import java.util.List;
import java.util.Set;

import com.sys.bio.back.cut.domain.models.CutType;

public interface CutTypeService {

    CutType addCutType(CutType cutType);

    CutType updateCutType(CutType cutType);

    Set<CutType> getCutTypes();

    public List<CutType> findAll();

    CutType getCutType(Long cutTypeId);

    void deleteCutType(Long cutTypeId);

    Double getMiniCutFactor();
    Double getStandardCutFactor();
    Double getBiggyCutFactor();

}
