/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.futureutils;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * Provide a generic function that will take a collection of objects of one type,
 * build a derived object asynchronously via Future, and then return the list
 * of built objects.
 * 
 * @author aar1069
 * @param <R> the type of objects being worked on
 * @param <T> the type of objects being produced
 */
public interface CollectionBuilderFromFutures<R, T> {

    /**
     * build the objects.
     * 
     * @param source the source collection
     * @param builder a function to build a new object (via Future) from an object
     * in the source collection
     * @return the newly built objects.
     */
    Collection<T> buildFromFutures(Collection<R> source, Function<R, Future<T>> builder);
    
}
