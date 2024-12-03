package com.sys.bio.back.product.app.ports.input;

import com.sys.bio.back.product.domain.models.ProductMovement;

import java.util.Set;

public interface ProductMovementService {

    Set<ProductMovement> getProductMovements();
}
