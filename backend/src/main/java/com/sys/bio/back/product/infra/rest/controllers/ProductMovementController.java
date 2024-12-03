package com.sys.bio.back.product.infra.rest.controllers;

import com.sys.bio.back.product.app.ports.input.ProductMovementService;
import com.sys.bio.back.product.domain.enums.ProductMovementType;
import com.sys.bio.back.product.app.ports.input.ProductService;
import com.sys.bio.back.product.domain.models.ProductMovement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product-movements")
public class ProductMovementController {

    private final ProductService productService;
    private final ProductMovementService movementService;

    @GetMapping("/")
    public ResponseEntity<?> listProductMovements() {
        return ResponseEntity.ok(movementService.getProductMovements());
    }

    @PostMapping("/add/{productId}")
    public ProductMovement addMovement(@PathVariable Long productId, @RequestBody Map<String, Object> payload) {
        int amount = (Integer) payload.get("amount");
        ProductMovementType productMovementType = ProductMovementType.valueOf((String) payload.get("productMovementType"));
        return productService.addMovement(productId, amount, productMovementType);
    }

}
