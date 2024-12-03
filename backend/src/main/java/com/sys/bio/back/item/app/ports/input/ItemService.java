package com.sys.bio.back.item.app.ports.input;


import com.sys.bio.back.item.domain.enums.ItemMovementType;
import com.sys.bio.back.item.domain.models.Item;
import com.sys.bio.back.item.domain.models.ItemMovement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ItemService {

    Item addItem(Item item);

    Item updateItem(Item item);

    Set<Item> getItems();

    Item updateCurrentAmount(Long itemId, int amount);

    ItemMovement addMovement(Long itemId, int amount, ItemMovementType movement);

    List<ItemMovement> getMovementsByItemAndDate(Long itemId, LocalDate startDate, LocalDate endDate);

    public List<Item> findAll();

    Item getItem(Long itemId);

    void deleteItem(Long itemId);

}
