package com.sys.bio.back.product.domain.models;

import com.sys.bio.back.product.domain.enums.ProductMovementType;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductMovement.class)
public abstract class ProductMovement_ {

	public static volatile SingularAttribute<ProductMovement, LocalDate> date;
	public static volatile SingularAttribute<ProductMovement, Long> productMovementId;
	public static volatile SingularAttribute<ProductMovement, Product> product;
	public static volatile SingularAttribute<ProductMovement, Integer> amount;
	public static volatile SingularAttribute<ProductMovement, LocalTime> hour;
	public static volatile SingularAttribute<ProductMovement, ProductMovementType> movement;

	public static final String DATE = "date";
	public static final String PRODUCT_MOVEMENT_ID = "productMovementId";
	public static final String PRODUCT = "product";
	public static final String AMOUNT = "amount";
	public static final String HOUR = "hour";
	public static final String MOVEMENT = "movement";

}

