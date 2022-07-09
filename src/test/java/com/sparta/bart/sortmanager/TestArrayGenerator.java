package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.controller.RandomArray;

import java.util.Arrays;

public class TestArrayGenerator extends RandomArray {

    private int[] sorted;

    public TestArrayGenerator(int size){
        unsorted = generateArray(size);
    }

    public int[] getSorted(){
        Arrays.sort(unsorted);
        return unsorted;
    }

}
