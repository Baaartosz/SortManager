package com.sparta.sortmanager;

/**
 * In order to update program functionality add new enum
 * containing name and class object.
 */
public enum Algorithms {
    BUBBLE_SORT("Bubble Sort", new BubbleSort());

    private final String name;
    private final Object sortClass;
    Algorithms(String name, Object sortClass) {
        this.name = name;
        this.sortClass = sortClass;
    }

    public String getName() {
        return name;
    }

    public Sorter getSorter(){
        Sorter s = (Sorter) sortClass;
        return s;
    }
}

