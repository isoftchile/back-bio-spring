package com.sys.bio.back.item.infra.adapters.output;

import com.sys.bio.back.item.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
