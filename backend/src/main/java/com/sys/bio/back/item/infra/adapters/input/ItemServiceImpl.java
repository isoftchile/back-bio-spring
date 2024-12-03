package com.sys.bio.back.item.infra.adapters.input;

import com.sys.bio.back.controllers.user.AuthenticationController;
import com.sys.bio.back.item.app.ports.input.ItemService;
import com.sys.bio.back.item.domain.enums.ItemMovementType;
import com.sys.bio.back.item.domain.models.Item;
import com.sys.bio.back.item.domain.models.ItemMovement;
import com.sys.bio.back.item.infra.adapters.output.ItemRepository;
import com.sys.bio.back.item.infra.adapters.output.ItemMovementRepository;
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
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private ItemMovementRepository storeRepo;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Override
    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Set<Item> getItems() {
        return new LinkedHashSet<>(itemRepo.findAll());
    }

    @Override
    public Item getItem(Long itemId) {
        return itemRepo.findById(itemId).get();
    }

    @Override
    public void deleteItem(Long itemId) {
        Item item = new Item();
        item.setItemId(itemId);
        itemRepo.delete(item);
    }

    @Override
    public Item updateCurrentAmount(Long itemId, int amount) {
        Item item = getItem(itemId);
        if (item != null) {
            item.setCurrentAmount(amount);
            return itemRepo.save(item);
        }
        return null;
    }

    @Override
    public ItemMovement addMovement(Long itemId, int amount, ItemMovementType movement) {
        Item item = getItem(itemId);
        if (item != null) {
            ItemMovement itemMovement = new ItemMovement();
            itemMovement.setItem(item);
            itemMovement.setAmount(amount);
            itemMovement.setMovement(movement);
            itemMovement.setDate(LocalDate.now());

            if (movement == ItemMovementType.INGRESO) {
                item.setCurrentAmount(item.getCurrentAmount() + amount);
            } else if (movement == ItemMovementType.EGRESO) {
                item.setCurrentAmount(item.getCurrentAmount() - amount);
            }

            itemRepo.save(item);
            return storeRepo.save(itemMovement);
        }
        return null;
    }

    @Override
    public List<ItemMovement> getMovementsByItemAndDate(Long itemId, LocalDate startDate, LocalDate endDate) {
        Item item = getItem(itemId);
        if (item != null) {
            return storeRepo.findByItemAndDateBetween(item, startDate, endDate);
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return (List<Item>) itemRepo.findAll();
    }

}
