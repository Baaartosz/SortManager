package com.sparta.sortmanager;


/*
 * DONE Give user bunch of algorithms to choose from
 * DONE Get user decision for algorithm
 * DONE Get preferred array length
 * DONE Generate random array of said size
 * DONE Sort algorithm
 * DONE Time algorithm performance
 * DONE Output sorted, unsorted and performance data.
 */

/*
 * TODO output to console in a cleaner format --> Could output to log file?
 * TODO create a SortManager class which handles code below.
 */

public class Main {
    public static void main(String[] args) {
        UserInterface.title();
        do{
            UserInterface.setup();

            SortHandler s = new SortHandler(UserInterface.getUserAlgorithmChoice(), UserInterface.getArraySize());

            UserInterface.informUserOfArrayFilling();
            s.fillArray();

            UserInterface.informUserOfArraySorting();
            s.sortArray();

            s.outputData();

        } while(UserInterface.doesUserWantToContinue());

    }
}