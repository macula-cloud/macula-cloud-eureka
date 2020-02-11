package org.macula.cloud.eureka.metrics;

import java.time.LocalDateTime;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	private Integer orderId = 1;

	@GetMapping(value = "/order")
	public ResponseEntity<Boolean> createOrder() {
		Order order = new Order();
		order.setAmount(RandomUtils.nextInt());
		order.setChannel("Hand");
		order.setCreateTime(LocalDateTime.now());
		order.setUserId(orderId * 1L);
		order.setOrderId(orderId++ + "");
		return ResponseEntity.ok(orderService.createOrder(order));
	}
}
