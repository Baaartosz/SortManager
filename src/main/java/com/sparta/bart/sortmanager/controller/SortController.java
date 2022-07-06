package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.model.Sorter;
import com.sparta.bart.sortmanager.view.SortView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class SortController {
    private final Timer performanceTimer = new Timer();
    private final SortView view;
    private final ArrayList<Sorters> algorithms = new ArrayList<Sorters>();

    private final int[] unsortedArray;
    private int[] sortedArray;

    private final ArrayList<String> timeReports = new ArrayList<>();

    public SortController(Sorters sortingAlgorithm, int arraySize, SortView sortView){ // add view class.
        algorithms.add(sortingAlgorithm);
        unsortedArray = new int[arraySize];
        sortedArray = new int[arraySize];
        view = sortView;
    }

    public SortController(ArrayList<Sorters> sortingAlgorithms, int arraySize, SortView sortView){ // add view class
        algorithms.addAll(sortingAlgorithms);
        unsortedArray = new int[arraySize];
        sortedArray = new int[arraySize];
        view = sortView;
    }

    private void fillArray(){
        Random rand = new Random();
        for (int i = 0; i < unsortedArray.length; i++)
            unsortedArray[i] = rand.nextInt(99999);
    }

    public void sortArray(){
        fillArray();
        for (Sorters s : algorithms) {
            performanceTimer.start();
            sortedArray = s.getSorter().sortArray(unsortedArray.clone());
            performanceTimer.end();
            timeReports.add(performanceTimer.getTimeTaken());
        }
    }

    public void printReport(){
        view.sortReport(algorithms, unsortedArray, sortedArray, timeReports);
    }

}
