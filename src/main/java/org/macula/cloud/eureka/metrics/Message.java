package org.macula.cloud.eureka.metrics;

import lombok.Data;

@Data
public class Message {
	
	private String orderId;
	private Long userId;
	private String content;
}
