package de.tekup.order.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ORDER_TB")
@Data
public class Order {
	@Id
	private int id;
	private String name;
	private int qty;
	private int price;
	
	private String transactionId;

}
