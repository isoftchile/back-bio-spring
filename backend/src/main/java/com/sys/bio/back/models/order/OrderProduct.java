package com.sys.bio.back.models.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sys.bio.back.product.domain.models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="orderProducts")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonProperty("order")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonProperty("product")
    private Product product;

    private Integer quantity;

    private Integer unityValue;

    private Integer totalValue;
}
