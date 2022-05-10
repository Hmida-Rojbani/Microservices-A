package de.tekup.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import de.tekup.order.dto.TransactionOrderReq;
import de.tekup.order.dto.TransactionPaymentRes;
import de.tekup.order.entities.Order;
import de.tekup.order.repos.OrderRepos;
import lombok.AllArgsConstructor;

@Service
public class OrderService {
	
	private OrderRepos orderRepos;
	private RestTemplate restTemplate;
	
	public OrderService(OrderRepos orderRepos, RestTemplate restTemplate) {
		super();
		this.orderRepos = orderRepos;
		this.restTemplate = restTemplate;
	}

	@Value("${gateway.ip}")
	private String GT_URL;
	
	public List<Order> getOrders(){
		return orderRepos.findAll();
	}
	
	public Order saveOrder(Order order) {
		TransactionOrderReq orderReq = new TransactionOrderReq(order.getId(), order.getQty()*order.getPrice());
		//call paymentService
		TransactionPaymentRes paymentRes = restTemplate.postForObject(GT_URL+"/payment/process",orderReq, TransactionPaymentRes.class);
		if(paymentRes.getPaymentStatus().equals("succes"))
			order.setTransactionId(paymentRes.getTransactionId());
		return orderRepos.save(order);
		
	}

}
