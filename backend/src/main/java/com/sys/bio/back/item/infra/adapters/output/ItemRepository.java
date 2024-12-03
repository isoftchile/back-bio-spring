package com.sys.bio.back.item.infra.adapters.output;

import com.sys.bio.back.item.domain.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
