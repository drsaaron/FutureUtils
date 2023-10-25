/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Provide a generic function that will take a collection of objects of one type,
 * build a derived object asynchronously via Future, and then return the list
 * of built objects.
 * 
 * @author aar1069
 * @param <R> the type of input object
 * @param <T> the type of output object
 */
public class CollectionBuilderFromFutures<R, T> implements BiFunction<Collection<R>, Function<R, Future<T>>, Collection<T>> {

    /**
     * take a collection of objects, for each build a new object asynchronously, and
     * finally collect the resulting objects.
     * 
     * @param source the source collection
     * @param builder a function to map an input object into a Future
     * @return the resulting collection of objects
     */
    @Override
    public Collection<T> apply(Collection<R> source, Function<R, Future<T>> builder) {
        return source.stream()
                .map(builder)
                .collect(Collectors.toList())
                .stream()
                .map(new FutureGetter<>())
                .collect(Collectors.toList());
    }
}
