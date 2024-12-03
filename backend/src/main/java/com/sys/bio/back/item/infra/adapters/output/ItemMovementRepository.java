package com.sys.bio.back.item.infra.adapters.output;

import com.sys.bio.back.item.domain.models.Item;
import com.sys.bio.back.item.domain.models.ItemMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemMovementRepository extends JpaRepository<ItemMovement, Long> {
    List<ItemMovement> findByItemAndDateBetween(Item item, LocalDate startDate, LocalDate endDate);
}
