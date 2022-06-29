package com.sparta.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class SortHandler {

    private Algorithms sortingAlgorithm;

    private int[] unsortedArray;
    private int[] sortedArray;

    private long timeTakenToComplete;

    public int[] getUnsortedArray() {
        return unsortedArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

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
        sortedArray = sortingAlgorithm.getSorter().sortArray(unsortedArray);
        long endTime = System.nanoTime();
        timeTakenToComplete = (endTime - startTime);
    }

    @Override
    public String toString() {
        return "SortHandler{" +
               "unsortedArray=" + Arrays.toString(unsortedArray) +
               ", sortedArray=" + Arrays.toString(sortedArray) +
               ", timeTakenToComplete=" + getTimeTakenToCompleteInMillis() +
               "ms}";
    }
}
