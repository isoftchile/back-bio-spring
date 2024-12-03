package com.sys.bio.back.product.infra.adapters.input;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.product.domain.enums.ProductMovementType;
import com.sys.bio.back.product.domain.models.Product;
import com.sys.bio.back.product.app.ports.input.ProductService;
import com.sys.bio.back.product.domain.models.ProductMovement;
import com.sys.bio.back.product.infra.adapters.output.ProductMovementRepository;
import com.sys.bio.back.product.infra.adapters.output.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductMovementRepository inventoryRepo;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Set<Product> getProducts() {
        return new LinkedHashSet<>(productRepo.findAll());
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = new Product();
        product.setProductId(productId);
        productRepo.delete(product);
    }

    @Override
    public Product updateCurrentAmountAdmin(Long productId, int amount) {
        Product product = getProduct(productId);
        if (product != null) {
            product.setCurrentAmount(amount);
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public ProductMovement addMovement(Long productId, int amount, ProductMovementType movement) {
        Product product = getProduct(productId);
        if (product != null) {
            ProductMovement productMovement = new ProductMovement();
            productMovement.setProduct(product);
            productMovement.setAmount(amount);
            productMovement.setMovement(movement);
            productMovement.setDate(LocalDate.now());

            if (movement == ProductMovementType.INGRESO) {
                product.setCurrentAmount(product.getCurrentAmount() + amount);
            } else if (movement == ProductMovementType.EGRESO) {
                product.setCurrentAmount(product.getCurrentAmount() - amount);
            }

            productRepo.save(product);
            return inventoryRepo.save(productMovement);
        }
        return null;
    }

    @Override
    public List<ProductMovement> getMovementsByProductAndDate(Long productId, LocalDate startDate, LocalDate endDate) {
        Product product = getProduct(productId);
        if (product != null) {
            return inventoryRepo.findByProductAndDateBetween(product, startDate, endDate);
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    @Transactional
    public void updateCurrentAmount(Long providerId, Long boxNameId, Long boxFormatId, int amount) {
        Product product = productRepo.findByProviderProviderIdAndBoxNameBoxNameIdAndBoxFormatBoxFormatId(providerId, boxNameId, boxFormatId);
        if (product != null) {
            product.setCurrentAmount(product.getCurrentAmount() + amount);
            productRepo.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Long getProductId(Long providerId, Long boxNameId, Long boxFormatId) {
        return productRepo.findByProviderProviderIdAndBoxNameBoxNameIdAndBoxFormatBoxFormatId(providerId, boxNameId, boxFormatId).getProductId();
    }
}
