package com.sys.bio.back.product.infra.adapters.output;

import com.sys.bio.back.product.domain.models.ProductMovement;
import com.sys.bio.back.product.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, Long> {

    List<ProductMovement> findByProductAndDateBetween(Product product, LocalDate startDate, LocalDate endDate);
}
