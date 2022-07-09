package com.sparta.bart.sortmanager.view;

import com.sparta.bart.sortmanager.controller.Sorters;

import java.util.ArrayList;
import java.util.Arrays;

public class SortView {
//    public void sortReport(Sorters sorter,int[] unsortedArray, int[] sortedArray, String time){
//        System.out.println("\nUnsorted Array : " + Arrays.toString(unsortedArray));
//        System.out.println("Sorted Array   : " + Arrays.toString(sortedArray));
//
//        System.out.println("\nSorting Algorithm Results for " + sorter.getName());
//
//        System.out.println("Time Taken : " + time);
//    }

    public void sortReport(ArrayList<Sorters> sorters, int[] unsortedArray, int[] sortedArray, ArrayList<String> testTimes){
        System.out.println("\nUnsorted Array : " + Arrays.toString(unsortedArray));
        System.out.println("Sorted Array   : " + Arrays.toString(sortedArray) + "\n");
        for (int i = 0; i < testTimes.size(); i++) {
            System.out.println(sorters.get(i).getName() + " : took " + testTimes.get(i));
        }
    }

//    private String displayArray(int[] array, boolean truncated){
//        if(array[0] == -1) return "Empty Array";
//        if(!truncated) return Arrays.toString(array) + " Size(" + array.length + ")";
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[ ");
//
//        for (int i = 0; i < 5; i++) {
//            stringBuilder.append(array[i]).append(", ");
//        }
//        stringBuilder.append("..., ..., ");
//
//        for (int i = array.length - 5; i < array.length; i++) {
//            stringBuilder.append(array[i]).append(", ");
//        }
//        stringBuilder.append(" ] Size(").append(array.length).append(")");
//
//        return stringBuilder.toString();
//    }
}
