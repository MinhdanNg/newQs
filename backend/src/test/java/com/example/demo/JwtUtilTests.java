package com.example.demo;

import com.example.demo.controller.TokenController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JwtUtilTests {

    @Test
    public void generateAndParseTokenTest() throws Exception {
        // generate
        TokenController jwtUtil = new TokenController();
        String token = jwtUtil.generateToken("userid");
        System.out.println(token);
        assertNotNull(token);
    }
}
