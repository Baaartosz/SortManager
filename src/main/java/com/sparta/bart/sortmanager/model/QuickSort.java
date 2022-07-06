package com.sparta.bart.sortmanager.model;

public class QuickSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort == null) return new int[] {-1};
        return quickSort(arrayToSort,0,arrayToSort.length-1);
    }

    private int[] quickSort(int[] array, int leftMost, int rightMost ){
        if(leftMost < rightMost){
            int pivot = partitionArray(array, leftMost, rightMost);
            quickSort(array, leftMost, pivot -1); // Left side of pivot
            quickSort(array, pivot + 1, rightMost); // Right side of pivot.
        }
        return array;
    }

    private int partitionArray(int[] array, int leftMost, int rightMost) {
        int pivot = array[rightMost];
        int i = (leftMost - 1);

        for (int j = leftMost; j < rightMost; j++) {
            if(array[j] <= pivot){
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[rightMost];
        array[rightMost] = temp;

        return (i + 1);
    }
}
