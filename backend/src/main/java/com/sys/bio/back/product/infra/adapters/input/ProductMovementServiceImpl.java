package com.sys.bio.back.product.infra.adapters.input;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.item.domain.models.ItemMovement;
import com.sys.bio.back.product.domain.enums.ProductMovementType;
import com.sys.bio.back.product.domain.models.Product;
import com.sys.bio.back.product.domain.models.ProductMovement;
import com.sys.bio.back.product.app.ports.input.ProductMovementService;
import com.sys.bio.back.product.infra.adapters.output.ProductMovementRepository;
import com.sys.bio.back.product.infra.adapters.output.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProductMovementServiceImpl implements ProductMovementService {

    private final ProductMovementRepository movementRepo;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Override
    public Set<ProductMovement> getProductMovements() {
        return new LinkedHashSet<>(movementRepo.findAll());
    }

}
