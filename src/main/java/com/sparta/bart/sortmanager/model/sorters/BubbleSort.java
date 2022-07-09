package com.sparta.bart.sortmanager.model.sorters;

import com.sparta.bart.sortmanager.controller.SortManager;
import com.sparta.bart.sortmanager.model.Sorter;

public class BubbleSort implements Sorter {

    /**
     * The Simplest sorting algorithm that works by repeatedly
     * swapping the adjacent elements if they are in wrong order.
     *
     * Time Complexity  -> O(n^2)
     * Space Complexity -> O(1)
     *
     * @param   array an array of integers sorted or unsorted.
     * @return        sorted array of integers.
     */
    public int[] sortArray(int[] array){
        if(array == null)  {
            SortManager.LOGGER.error("Null Array provided for Sort. Returning empty array.");
            return new int[0];
        }

        for (int outer = 0; outer < array.length - 1; outer++) {
            boolean swapped = false;

            for (int inner = 0; inner < array.length - 1; inner++) {
                if(array[inner + 1] < array[inner]){
                    int swap = array[inner];
                    array[inner] = array[inner + 1];
                    array[inner + 1] = swap;

                    swapped = true;
                }
            }

            // No swapping is occurring, we can break out of the loop.
            if (!swapped)
                break;
        }
        return array;
    }

}
