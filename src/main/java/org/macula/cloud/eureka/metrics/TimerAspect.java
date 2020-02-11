package org.macula.cloud.eureka.metrics;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;

@Component
@Aspect
public class TimerAspect {

	@Around(value = "execution(* org.macula.cloud.eureka.metrics.*Service.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		Timer timer = Metrics.timer("method.cost.time", "method.name", method.getName());
		ThrowableHolder holder = new ThrowableHolder();
		Object result = timer.recordCallable(() -> {
			try {
				return joinPoint.proceed();
			} catch (Throwable e) {
				holder.throwable = e;
			}
			return null;
		});
		if (null != holder.throwable) {
			throw holder.throwable;
		}
		return result;
	}

	private class ThrowableHolder {
		Throwable throwable;
	}
}
