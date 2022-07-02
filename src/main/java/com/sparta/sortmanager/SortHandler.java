package com.sparta.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class SortHandler{
    private Timer performanceTimer = new Timer();
    private Algorithms sortingAlgorithm;
    private int[] unsortedArray;
    private int[] sortedArray;

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
        performanceTimer.start();
        sortedArray = sortingAlgorithm.getSorter().sortArray(unsortedArray.clone());
        performanceTimer.end();
    }

    public void outputData(boolean truncated){
        System.out.println("\nSorting Algorithm Results for " + sortingAlgorithm.getName());
        System.out.println("Unsorted Array : " + displayArray(unsortedArray, truncated));
        System.out.println("Sorted Array   : " + displayArray(sortedArray, truncated));
        System.out.println("Time Taken : " + performanceTimer.getTimeTaken());
    }

    private String displayArray(int[] array, boolean truncated){
        if(!truncated) return Arrays.toString(array) + " Size(" + array.length + ")";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");

        for (int i = 0; i < 5; i++) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.append("..., ..., ");

        for (int i = array.length - 5; i < array.length; i++) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.append(" ] Size(").append(array.length).append(")");

        return stringBuilder.toString();
    }

}
