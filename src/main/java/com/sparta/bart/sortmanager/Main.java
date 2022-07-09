package com.sparta.bart.sortmanager;

/* Sort Manager Task List
 * TODO update README.md
 * DONE Implement OOP and SOLID principles
 * TODO Logging
 *      TODO Log4j
 *      TODO .properties
 * TODO Binary Search Tree
 * DONE Inner class Node
 * TODO Binary Sort
 * TODO Exceptions?
 *     - SortFailedException --> Invalid array returned from sort method; e.g. [ - 1 ] or Null
 *     - NullPointerException --> Null array provided.
 *     - DuplicateNumberException --> number array is not unique.
 */

/*
    EXPLORE An interface that has a runnableTest?
 */

import com.sparta.bart.sortmanager.controller.SortManager;

public class Main {
    public static void main(String[] args) {
        SortManager.start();
    }
}