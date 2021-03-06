package de.tekup.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPaymentRes {

	private String paymentStatus;
	private String transactionId;
}
