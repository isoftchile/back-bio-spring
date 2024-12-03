package com.sys.bio.back.product.domain.models;

import com.sys.bio.back.product.domain.enums.ProductMovementType;
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
@Table(name = "product_movements")
public class ProductMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productMovementId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private Integer amount;
    @Enumerated(EnumType.STRING)
    private ProductMovementType movement;
    private LocalDate date;
    private LocalTime hour;

}
