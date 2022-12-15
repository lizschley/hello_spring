package com.example.helloworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CheckHTTPResponse {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldPassIfStringMatches() throws Exception {
        String text = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertTrue(text.contains("Hello World!"));
    }

    @Test
    public void shouldPassIfStringDoesNotMatch() throws Exception {
        String text = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertFalse(text.contains("Goodbye World!"));
    }
}

