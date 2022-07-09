package com.sparta.bart.sortmanager.view;

import com.sparta.bart.sortmanager.controller.SortManager;
import com.sparta.bart.sortmanager.controller.Sorters;

import java.util.ArrayList;
import java.util.Arrays;
public class SortView {

    public void sortReport(ArrayList<Sorters> sorters, int[] unsortedArray, int[] sortedArray, ArrayList<String> testTimes){
        System.out.println("\nUnsorted Array : " + Arrays.toString(unsortedArray));
        System.out.println("Sorted Array   : " + Arrays.toString(sortedArray) + "\n");
        for (int i = 0; i < testTimes.size(); i++) {
            System.out.println(sorters.get(i).getName() + " --> " + testTimes.get(i));
        }
        SortManager.LOGGER.debug(Arrays.toString(sorters.toArray()));
        SortManager.LOGGER.debug(Arrays.toString(testTimes.toArray()));
    }
}
