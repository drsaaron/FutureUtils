/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class CollectionBuilderFromFuturesImplTest {
    
    private static final Logger logger = LoggerFactory.getLogger(CollectionBuilderFromFuturesImplTest.class);
    
    @TestConfiguration
    public static class CollectionBuilderFromFuturesImplTestConfiguration {
        
        @Bean
        public CollectionBuilderFromFuturesImpl<String, Integer> instance() {
            return new CollectionBuilderFromFuturesImpl<>();
        }
    }
    
    @Autowired
    private CollectionBuilderFromFuturesImpl<String, Integer> instance;
    
    public CollectionBuilderFromFuturesImplTest() {
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

    private static final Map<String, Integer> NAME_AGE_MAP = Map.of("person1", 25, "person2", 50);
    
    /**
     * Test of buildFromFutures method, of class CollectionBuilderFromFuturesImpl.
     */
    @Test
    public void testBuildFromFutures() {
        logger.info("buildFromFutures");
        
        Collection<String> names = NAME_AGE_MAP.keySet();
        Collection<Integer> ages = instance.buildFromFutures(names, n -> CompletableFuture.completedFuture(NAME_AGE_MAP.get(n)));
        
        assertEquals(names.size(), ages.size());
        Integer firstAge = ages.iterator().next();
        assertTrue(NAME_AGE_MAP.get("person1") == firstAge || NAME_AGE_MAP.get("person2") == firstAge);
    }
    
}
