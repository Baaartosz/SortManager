package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;

import java.util.ArrayList;
import java.util.Arrays;

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
        SortManager.LOGGER.debug("Filling array with random integers");
        unsortedArray = randomArray.generateArray(sortedArray.length);
    }

    public void sortArray(){ // TODO Singleton Logger Static -> implements interface Loggable
        fillArray();
        for (Sorters s : algorithms) {
            SortManager.LOGGER.info(s.getName() + " running sort...");
            performanceTimer.start();

            try {
                sortedArray = s.getSorter().sortArray(unsortedArray.clone());
                performanceTimer.end();
                SortManager.LOGGER.info(s.getName() + " finished sort!");
            }catch (StackOverflowError stackOverflowError){
                System.err.println(s.getName() + " failed --> ran out of memory. Please increase memory to JVM.");
                SortManager.LOGGER.fatal("StackOverflow inside " + s.getName() + "\n" + stackOverflowError.getStackTrace()[0]);
                performanceTimer.reset();
                sortedArray = new int[0];
            }catch(Exception e){
                SortManager.LOGGER.fatal(e.getStackTrace());
            }

            if(sortedArray.length == 0) SortManager.LOGGER.error(s.getName() + " failed to sort array. ");
            timeReports.add(performanceTimer.getTimeTaken());
        }
    }

    public void printReport(){
        view.sortReport(algorithms, unsortedArray, sortedArray, timeReports);
    }

}
