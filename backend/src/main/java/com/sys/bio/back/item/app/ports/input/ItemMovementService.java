package com.sys.bio.back.item.app.ports.input;

import com.sys.bio.back.item.domain.models.ItemMovement;

import java.util.Set;

public interface ItemMovementService {

    Set<ItemMovement> getItemMovements();
}
