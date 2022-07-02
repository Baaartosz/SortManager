package com.sparta.sortmanager;

/**
 * Enum Factory Pattern
 */
public enum Algorithms {
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
    BINARY_SORT("Binary Sort (Not Implemented)") {
        @Override
        public Sorter getSorter() { return new BinarySort(); }
    },
    QUICK_SORT("Quick Sort (Not Implemented)") {
        @Override
        public Sorter getSorter(){
            return new QuickSort();
        }
    },
    INSERTION_SORT("Insertion Sort (Not Implemented)") {
        @Override
        public Sorter getSorter(){
            return new InsertionSort();
        }
    };

    /*
     * DONE Bubble Sort
     * TODO Binary Sort
     * TODO Insertion Sort
     * DONE Merge Sort
     * TODO Quick Sort
     */

    private String name;

    public String getName() {
        return name;
    }

    Algorithms(String algoName) {
        name = algoName;
    }

    public abstract Sorter getSorter();
}

