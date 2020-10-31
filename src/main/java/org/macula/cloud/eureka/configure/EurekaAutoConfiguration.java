package org.macula.cloud.eureka.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = { "org.macula.cloud.eureka" })
public class EurekaAutoConfiguration {

}
