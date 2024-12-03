package com.sys.bio.back.item.infra.adapters.input;

import com.sys.bio.back.item.app.ports.input.ItemMovementService;
import com.sys.bio.back.item.domain.models.ItemMovement;
import com.sys.bio.back.item.infra.adapters.output.ItemMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemMovementServiceImpl implements ItemMovementService {

    private final ItemMovementRepository movementRepo;

    @Override
    public Set<ItemMovement> getItemMovements() {
        return new LinkedHashSet<>(movementRepo.findAll());
    }
}
