/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * a generic function to get the value from a future, handling the exceptions,
 * useful in streams
 * 
 * @author aar1069
 * @param <T>
 */
public class FutureGetter<T> implements Function<Future<T>, T> {

    @Override
    public T apply(Future<T> t) {
        try {
            return t.get();
        } catch (ExecutionException|InterruptedException e) {
            throw new RuntimeException("error getting from future: " + e.getMessage(), e);
        }
    }
    
    
}
