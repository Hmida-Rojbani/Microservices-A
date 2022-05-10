package de.tekup.payment.entites;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="PAYMENT_TB")
@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	private String paymentStatus;
	private String transactionId;
	
	
	private int orderId;
	private double amount;

}
