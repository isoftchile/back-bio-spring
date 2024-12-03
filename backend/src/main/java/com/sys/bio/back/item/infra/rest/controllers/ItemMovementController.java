package com.sys.bio.back.item.infra.rest.controllers;

import com.sys.bio.back.item.app.ports.input.ItemMovementService;
import com.sys.bio.back.item.domain.enums.ItemMovementType;
import com.sys.bio.back.item.domain.models.ItemMovement;
import com.sys.bio.back.item.app.ports.input.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movements")
public class ItemMovementController {

    private final ItemMovementService movementService;

    private final ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<?> listItemMovements() {
        return ResponseEntity.ok(movementService.getItemMovements());
    }

    @PostMapping("/add/{itemId}")
    public ItemMovement addMovement(@PathVariable Long itemId, @RequestBody Map<String, Object> payload) {
        int amount = (Integer) payload.get("amount");
        ItemMovementType itemMovementType = ItemMovementType.valueOf((String) payload.get("itemMovementType"));
        return itemService.addMovement(itemId, amount, itemMovementType);
    }

    @GetMapping("/list/{itemId}")
    public List<ItemMovement> getMovementsByItemAndDate(@PathVariable Long itemId, @RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return itemService.getMovementsByItemAndDate(itemId, start, end);
    }
}
