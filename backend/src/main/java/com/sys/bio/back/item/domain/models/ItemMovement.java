package com.sys.bio.back.item.domain.models;

import com.sys.bio.back.item.domain.enums.ItemMovementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "itemMovements")
public class ItemMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemMovementId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;
    private Integer amount;
    @Enumerated(EnumType.STRING)
    private ItemMovementType movement;
    private LocalDate date;
    private LocalTime hour;
}
