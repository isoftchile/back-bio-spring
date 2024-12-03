package com.sys.bio.back.item.domain.models;

import com.sys.bio.back.item.domain.enums.ItemMovementType;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemMovement.class)
public abstract class ItemMovement_ {

	public static volatile SingularAttribute<ItemMovement, LocalDate> date;
	public static volatile SingularAttribute<ItemMovement, Item> item;
	public static volatile SingularAttribute<ItemMovement, Integer> amount;
	public static volatile SingularAttribute<ItemMovement, LocalTime> hour;
	public static volatile SingularAttribute<ItemMovement, ItemMovementType> movement;
	public static volatile SingularAttribute<ItemMovement, Long> itemMovementId;

	public static final String DATE = "date";
	public static final String ITEM = "item";
	public static final String AMOUNT = "amount";
	public static final String HOUR = "hour";
	public static final String MOVEMENT = "movement";
	public static final String ITEM_MOVEMENT_ID = "itemMovementId";

}

