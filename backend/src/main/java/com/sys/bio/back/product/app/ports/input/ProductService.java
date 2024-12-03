package com.sys.bio.back.product.app.ports.input;

import com.sys.bio.back.product.domain.enums.ProductMovementType;
import com.sys.bio.back.product.domain.models.Product;
import com.sys.bio.back.product.domain.models.ProductMovement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Set<Product> getProducts();

    Product updateCurrentAmountAdmin(Long productId, int amount);

    ProductMovement addMovement(Long productId, int amount, ProductMovementType movement);

    List<ProductMovement> getMovementsByProductAndDate(Long productId, LocalDate startDate, LocalDate endDate);

    public List<Product> findAll();

    Product getProduct(Long productId);

    void deleteProduct(Long productId);

    @Transactional
    void updateCurrentAmount(Long providerId, Long boxNameId, Long boxFormatId, int amount);

    Long getProductId(Long providerId, Long boxNameId, Long boxFormatId);
}
