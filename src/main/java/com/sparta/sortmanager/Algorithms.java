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
    BINARY_SORT("Binary Sort (Not Implemented)") {
        @Override
        public Sorter getSorter() { return new BinarySort(); }
    },
    MERGE_SORT("Merge Sort (Not Implemented)") {
        @Override
        public Sorter getSorter(){
            return new QuickSort();
        }
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
     * TODO Merge Sort
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

