package com.anpq.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.anpq.spring.message.MessageProvider;
import com.anpq.spring.message.MessageRenderer;

public class AppTest extends TestBase {
    @Autowired
    MessageProvider provider;

    @Autowired
    MessageRenderer render;

    @Test
    public void testProvider() {
        assertNotNull(provider);
    }

    @Test
    public void testRender() {
        assertNotNull(render);
        assertNotNull(render.getMessageProvider());
    }
}
