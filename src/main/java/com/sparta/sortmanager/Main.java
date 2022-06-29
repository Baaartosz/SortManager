package com.sparta.sortmanager;


import java.util.Arrays;

/**
 * DONE Give user bunch of algorithms to choose from
 * DONE Get user decision for algorithm
 * DONE Get preferred array length
 * DONE Generate random array of said size
 * DONE Sort algorithm
 * DONE Time algorithm performance
 * DONE Output sorted, unsorted and performance data.
 */

public class Main {
    public static void main(String[] args) {
        //System.err.print("Test");
        // startup
        // into LOOP
        //      get info from user
        //      run sorting stuff
        //      ask for confirmation to continue or quit
        // end LOOP
        UserInterface.title();
        do{
            UserInterface.start();

            SortHandler s = new SortHandler(UserInterface.getUserAlgorithmChoice(), UserInterface.getArraySize());
            s.fillArray();
            s.sortArray();

            System.out.println(s);


        }while(true); // FIXME maybe add a boolean?

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
Suggested Project Phases
Phase 1
Write a program which will take an array of ints and sort it using a bubble sort algorithm.
Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time)
 */