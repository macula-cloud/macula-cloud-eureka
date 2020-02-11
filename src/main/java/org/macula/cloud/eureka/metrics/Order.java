package org.macula.cloud.eureka.metrics;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Order {

	private String orderId;
	private Long userId;
	private Integer amount;
	private String channel;
	private LocalDateTime createTime;

}
