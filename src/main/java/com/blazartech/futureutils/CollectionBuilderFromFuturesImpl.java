/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Provide a generic function that will take a collection of objects of one type,
 * build a derived object asynchronously via Future, and then return the list
 * of built objects.
 * 
 * @author aar1069
 * @param <R>
 * @param <T>
 */
public class CollectionBuilderFromFuturesImpl<R, T> implements CollectionBuilderFromFutures<R, T> {
 
    @Override
    public Collection<T> buildFromFutures(Collection<R> source, Function<R, Future<T>> builder) {
        return source.stream()
                .map(builder)
                .collect(Collectors.toList())
                .stream()
                .map(new FutureGetter<>())
                .collect(Collectors.toList());
    }
}
