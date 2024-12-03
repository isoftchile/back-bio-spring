package com.sys.bio.back.product.infra.adapters.output;

import com.sys.bio.back.product.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProviderProviderIdAndBoxNameBoxNameIdAndBoxFormatBoxFormatId(Long providerId,Long boxNameId, Long boxFormatId);
}
