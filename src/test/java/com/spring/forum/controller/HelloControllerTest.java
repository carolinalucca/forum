package com.spring.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;


@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void deveRetornarHelloWorld() {
        assertEquals(helloController.hello(), "Hello World");
    }
}
