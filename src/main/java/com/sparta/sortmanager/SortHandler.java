package com.sparta.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class SortHandler {

    private Algorithms sortingAlgorithm;
    private int[] unsortedArray;
    private int[] sortedArray;
    private long timeTakenToComplete;

    public float getTimeTakenToCompleteInMillis() {
        return (float)timeTakenToComplete / 1000000;
    }

    public SortHandler(Algorithms sortingAlgorithm, int arraySize){
        this.sortingAlgorithm = sortingAlgorithm;
        unsortedArray = new int[arraySize];
        sortedArray = new int[arraySize];
    }

    public void fillArray(){
        Random rand = new Random();
        for (int i = 0; i < unsortedArray.length; i++)
            unsortedArray[i] = rand.nextInt(99999);
    }

    public void sortArray(){
        long startTime = System.nanoTime();
        sortedArray = sortingAlgorithm.getSorter().sortArray(unsortedArray.clone());
        long endTime = System.nanoTime();
        timeTakenToComplete = (endTime - startTime);
    }

    public void outputData(){
        System.out.println("\nSorting Algorithm Results for " + sortingAlgorithm.getName());
        System.out.println("Unsorted Array : " + Arrays.toString(unsortedArray));
        System.out.println("Sorted Array   : " + Arrays.toString(sortedArray));
        System.out.println("Time Taken : " + getTimeTakenToCompleteInMillis() + "ms");
    }
}
