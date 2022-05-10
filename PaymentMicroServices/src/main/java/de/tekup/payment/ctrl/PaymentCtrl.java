package de.tekup.payment.ctrl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.payment.dto.TransactionOrderReq;
import de.tekup.payment.dto.TransactionPaymentRes;
import de.tekup.payment.entites.Payment;
import de.tekup.payment.services.PaymentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentCtrl {
	
	private PaymentService paymentService;
	
	@GetMapping("/all")
	public List<Payment> getAllPayments(){
		return paymentService.getPayments();
	}
	@PostMapping("/process")
	public TransactionPaymentRes processPayment(@RequestBody TransactionOrderReq orderReq) {
		return paymentService.traitPayment(orderReq);
	}

}
