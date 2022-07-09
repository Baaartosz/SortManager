package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;

import java.util.ArrayList;

// TODO maybe implement a 'Timable' interface. and use timer object via that. ?????
// TODO!!! implement a non duplicate random fill interface and class implementing it.

public class SortController {
    private final Timer performanceTimer = new Timer();
    private final SortView view;
    private final ArrayList<Sorters> algorithms = new ArrayList<>();
    private final ArrayList<String> timeReports = new ArrayList<>();
    private int[] unsortedArray;
    private int[] sortedArray;


//    public SortController(Sorters sortingAlgorithm, int arraySize, SortView sortView){ // add view class.
//        algorithms.add(sortingAlgorithm);
//        unsortedArray = new int[arraySize];
//        sortedArray = new int[arraySize];
//        view = sortView;
//    }

    public SortController(ArrayList<Sorters> sortingAlgorithms, int arraySize, SortView sortView){ // add view class
        algorithms.addAll(sortingAlgorithms);
        unsortedArray = new int[arraySize];
        sortedArray = new int[arraySize];
        view = sortView;
    }

    private void fillArray(){ // TODO move to separate class ( S ) single responsibility
        RandomArray randomArray = new RandomArray();
        unsortedArray = randomArray.generateArray(sortedArray.length);
    }

    public void sortArray(){
        fillArray();
        for (Sorters s : algorithms) {
            performanceTimer.start(); // TODO create custom exception for invalid array return.
            var array = s.getSorter().sortArray(unsortedArray.clone());
            performanceTimer.end();

            sortedArray = array;
            timeReports.add(performanceTimer.getTimeTaken());
        }
    }

    public void printReport(){
        view.sortReport(algorithms, unsortedArray, sortedArray, timeReports);
    }

}
