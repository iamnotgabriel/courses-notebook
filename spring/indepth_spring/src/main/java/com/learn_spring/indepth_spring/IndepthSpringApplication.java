package com.learn_spring.indepth_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learn_spring.indepth_spring.GreeterImpl;

@SpringBootApplication
public class IndepthSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(IndepthSpringApplication.class, args);
		GreeterImpl greater = ctx.getBean(GreeterImpl.class);
		greater.greet();
	}

}
