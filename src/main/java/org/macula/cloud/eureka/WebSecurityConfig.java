package org.macula.cloud.eureka;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/actuator/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("Override httpSecurity use httpBasic authentication.");
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
