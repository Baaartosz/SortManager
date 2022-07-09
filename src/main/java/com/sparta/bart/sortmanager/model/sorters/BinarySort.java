package com.sparta.bart.sortmanager.model.sorters;

import com.sparta.bart.sortmanager.controller.SortManager;
import com.sparta.bart.sortmanager.model.BinarySearchTree;
import com.sparta.bart.sortmanager.model.Sorter;

public class BinarySort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort == null)  {
            SortManager.LOGGER.error("Null Array provided for Sort. Returning empty array.");
            return new int[0];
        }

        BinarySearchTree bst = new BinarySearchTree(arrayToSort);
        return bst.getArray();
    }
}
