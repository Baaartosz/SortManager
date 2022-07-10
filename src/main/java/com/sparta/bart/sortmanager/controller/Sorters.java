package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.model.*;
import com.sparta.bart.sortmanager.model.sorters.*;

/**
 * Enum Factory of Sorters
 * */
public enum Sorters {
    BUBBLE_SORT("Bubble Sort") {
        @Override
        public Sorter getSorter(){
            return new BubbleSort();
        }
    },
    MERGE_SORT("Merge Sort") {
        @Override
        public Sorter getSorter(){
            return new MergeSort();
        }
    },
    BINARY_SORT("Binary Sort") {
        @Override
        public Sorter getSorter() { return new BinarySort(); }
    },
    QUICK_SORT("Quick Sort") {
        @Override
        public Sorter getSorter(){
            return new QuickSort();
        }
    },
    INSERTION_SORT("Insertion Sort") {
        @Override
        public Sorter getSorter(){
            return new InsertionSort();
        }
    };

    private final String name;
    public String getName() {
        return name;
    }
    Sorters(String algoName) {
        name = algoName;
    }
    public abstract Sorter getSorter();
}

