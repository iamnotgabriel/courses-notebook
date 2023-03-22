package com.learn_spring.indepth_spring;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GreeterTest {

    // Mockito does not work with interfaces
    @Mock
    private Goodbye goodbyeMock;

    @InjectMocks
    private GreeterImpl greeterMock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    GreeterImpl greeter;
    @Test
    void testGreetSaysInPortuguese() {
        String result = greeter.greet();
        assertEquals("Hi, you are awesome, tchau", result);
    }

    @Test
    void testGreetSaysInEnglish() {
        String result = new GreeterImpl(new GoodbyeEnglish()).greet();
        assertEquals("Hi, you are awesome, goodbye", result);
    }

    @Test
    void testGreetSaysWithMock() {
        when(greeterMock.portugueseGoodbye.say()).thenReturn("mock message");
        assertEquals("Hi, you are awesome, mock message", greeterMock.greet());
    }
}