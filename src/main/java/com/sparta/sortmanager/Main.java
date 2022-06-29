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
 * TODO output to console in a cleaner format.
 * TODO
 *
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

/*
Sort Manager Project
Requirements:
You will be building a program that will allow a user to sort a randomised array. The general flow of the application is:

The user is presented with a number of sort algorithms to choose from.
Decision is given via the command line (using Scanner).
The program will then ask for the length of an array again via the command line.
The program should then output:
The unsorted randomly generated array
The sort algorithm to be used
The sorted array after the algorithm has been executed
The time taken You are required to test both the functionality of the program and the performance of the algorithms (speed tests)
 */