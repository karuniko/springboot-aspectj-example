package com.example;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
@Configuration
@EnableLoadTimeWeaving
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {

	@Bean
	public SomeTestAspect someTestAspect() {
		return Aspects.aspectOf(SomeTestAspect.class);
	}
}


