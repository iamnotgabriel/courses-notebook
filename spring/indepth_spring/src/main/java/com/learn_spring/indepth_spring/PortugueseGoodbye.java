package com.learn_spring.indepth_spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PortugueseGoodbye implements  Goodbye {
    public String say() {
        return "tchau";
    }


    @PostConstruct()
    @PreDestroy()
    private void preDestroy () {
        System.out.println(say());
    }
}
