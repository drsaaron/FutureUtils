/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author aar1069
 */
@ExtendWith(SpringExtension.class)
public class FutureGetterTest {
    
    private static final Logger logger = LoggerFactory.getLogger(FutureGetterTest.class);
    
    @TestConfiguration
    public static class FutureGetterTestConfiguration {
        
        @Bean
        public FutureGetter<String> instance() {
            return new FutureGetter<>();
        }
    }
    
    @Autowired
    private FutureGetter<String> instance;
    
    public FutureGetterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of apply method, of class FutureGetter.
     */
    @Test
    public void testApply() {
        logger.info("apply");
        
        String value = "my string";
        Future<String> stringFuture = CompletableFuture.completedFuture(value);
        String foundValue = instance.apply(stringFuture);
        
        assertEquals(value, foundValue);
    }
    
}
