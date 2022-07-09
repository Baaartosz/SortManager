package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;

import java.util.ArrayList;

public class SortController {
    private final Timer performanceTimer = new Timer();
    private final SortView view;
    private final ArrayList<Sorters> algorithms = new ArrayList<>();
    private final ArrayList<String> timeReports = new ArrayList<>();
    private int[] unsortedArray;
    private int[] sortedArray;

    public SortController(ArrayList<Sorters> sortingAlgorithms, int arraySize, SortView sortView){
        algorithms.addAll(sortingAlgorithms);
        unsortedArray = new int[arraySize];
        sortedArray = new int[arraySize];
        view = sortView;
    }

    protected void fillArray(){
        RandomArray randomArray = new RandomArray();
        SortManager.LOGGER.info("Filling array with random integers");
        unsortedArray = randomArray.generateArray(sortedArray.length);
    }

    public void sortArray(){
        fillArray();
        for (Sorters s : algorithms) {
            SortManager.LOGGER.debug(s.getName() + " running sort...");
            performanceTimer.start();

            try {
                sortedArray = s.getSorter().sortArray(unsortedArray.clone());
                performanceTimer.end();
                SortManager.LOGGER.debug(s.getName() + " finished sort!");
            }catch (StackOverflowError stackOverflowError){
                SortManager.LOGGER.fatal("StackOverflow inside " + s.getName() + ", size(" + sortedArray.length + ")");
                performanceTimer.reset();
                sortedArray = new int[0];
            }

            if(sortedArray.length == 0) SortManager.LOGGER.warn(s.getName() + " failed to sort array. ");
            timeReports.add(performanceTimer.getTimeTaken());
        }
    }

    public void printReport(){
        view.sortReport(algorithms, unsortedArray, sortedArray, timeReports);
    }

}
