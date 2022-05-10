package de.tekup.payment.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import de.tekup.payment.dto.TransactionOrderReq;
import de.tekup.payment.dto.TransactionPaymentRes;
import de.tekup.payment.entites.Payment;
import de.tekup.payment.repos.PaymentRepos;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	
	private PaymentRepos paymentRepos;
	
	public List<Payment> getPayments(){
		return paymentRepos.findAll();
	}
	
	public TransactionPaymentRes traitPayment(TransactionOrderReq txs) {
		Payment payment = new Payment();
		payment.setOrderId(txs.getOrderId());
		payment.setAmount(txs.getAmount());
		payment.setPaymentStatus(payProcess());
		if(payment.getPaymentStatus().equals("succes")) 
			payment.setTransactionId(UUID.randomUUID().toString());
		paymentRepos.save(payment);
		return new TransactionPaymentRes
				(payment.getPaymentStatus(), payment.getTransactionId());
	}
	//simulation of 3rd party payment service(paypal)
	private String payProcess() {
		return new Random().nextBoolean()?"succes":"failed";
	}

}
