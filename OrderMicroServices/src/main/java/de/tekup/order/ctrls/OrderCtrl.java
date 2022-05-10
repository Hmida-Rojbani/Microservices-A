package de.tekup.order.ctrls;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.order.entities.Order;
import de.tekup.order.services.OrderService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderCtrl {
	
	private OrderService orderService;
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return orderService.getOrders();
	}
	
	@PostMapping("/book")
	public Order bookOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/works")
	public String works() {
		return "ORDER-SERVICE works!!!";
	}

}
