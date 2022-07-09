package com.sparta.bart.sortmanager.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomArray {
    protected int[] unsorted;

    public int[] getUnsorted() {
        return unsorted;
    }

    public int[] generateArray(int size){
        return generateArray(size, 1_000_000);
    }
    public int[] generateArray(int size, int bound){
        unsorted = new int[size];
        Random rand = new Random();
        Set<Integer> usedNumbers = new HashSet<Integer>();
        for (int i = 0; i < unsorted.length; i++)
            do{
                var num = rand.nextInt(bound);
                if(!usedNumbers.contains(num)){
                    unsorted[i] = num;
                    usedNumbers.add(num);
                    break;
                }
            }while(true);
        return unsorted;
    }
}
