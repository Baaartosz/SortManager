package com.sparta.bart.sortmanager.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomArray {
    protected int[] unsorted;
    protected final int MAX_ITERATIONS;
    protected int currentIteration = 0;

    public RandomArray(){
        MAX_ITERATIONS = 100;
    }
    public RandomArray(int maxIterations){
        MAX_ITERATIONS = maxIterations;
    }

    public int[] getUnsorted() {
        return unsorted;
    }

    public int[] generateArray(int size){
        return generateArray(size, Integer.MAX_VALUE);
    }
    public int[] generateArray(int size, int bound){
        unsorted = new int[size];
        Random rand = new Random();
        HashSet<Integer> usedNumbers = new HashSet<>();
        for (int i = 0; i < unsorted.length; i++) {
            var num = rand.nextInt(bound);
            while (currentIteration < MAX_ITERATIONS) {
                if (!usedNumbers.contains(num)) {
                    unsorted[i] = num;
                    usedNumbers.add(num);
                    currentIteration = 0;
                    break;
                }
                currentIteration++;
            }
        }
        return unsorted;
    }
}
