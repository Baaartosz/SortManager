package com.sparta.bart.sortmanager;

/* Sort Manager Task List
 * TODO update README.md
 * DONE Implement OOP and SOLID principles
 * DONE Logging
 *      TODO Log4j
 *      TODO .properties
 * DONE Binary Search Tree
 * DONE Inner class Node
 * DONE Binary Sort
 * UNSURE Exceptions?
 *     - SortFailedException --> Invalid array returned from sort method; e.g. [ - 1 ] or Null
 *     - NullArrayProvidedException --> Null array provided.
 *     - DuplicateNumberException --> number array is not unique.
 * TODO write tests for Random Array.
 */

/*
    EXPLORE An interface that has a runnableTest?
 */

import com.sparta.bart.sortmanager.controller.SortManager;

public class Main {
    public static void main(String[] args) {
        SortManager.LOGGER.info("_______________ NEW RUN _______________");
        SortManager.start();
    }
}