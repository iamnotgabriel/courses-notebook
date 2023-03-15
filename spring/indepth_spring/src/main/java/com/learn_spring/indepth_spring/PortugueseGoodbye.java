package com.learn_spring.indepth_spring;

import org.springframework.stereotype.Component;

@Component
public class PortugueseGoodbye implements  Goodbye {
    public String say() {
        return "tchau";
    }
}
