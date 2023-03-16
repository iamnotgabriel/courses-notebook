package com.learn_spring.indepth_spring;

import org.springframework.stereotype.Component;

@Component
public class GoodbyeEnglish implements  Goodbye {
    @Override
    public String say() {
        return "goodbye";
    }
}
