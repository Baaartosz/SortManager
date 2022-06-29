package com.sparta.sortingalgorithms;

public class Bubble {

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
    public static int[] sort(int[] array){
        if(array == null) return new int[] {};
        for (int outer = 0; outer < array.length - 1; outer++) {
            for (int inner = 0; inner < array.length - 1; inner++) {

                if(array[inner + 1] < array[inner]){
                    int swap = array[inner];
                    array[inner] = array[inner + 1];
                    array[inner + 1] = swap;
                }

            }
        }
        return array;
    }

}
