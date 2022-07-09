package com.sparta.bart.sortmanager.model.sorters;

import com.sparta.bart.sortmanager.model.BinarySearchTree;
import com.sparta.bart.sortmanager.model.Sorter;

public class BinarySort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort == null) return new int[0]; // TODO exception
        BinarySearchTree bst = new BinarySearchTree(arrayToSort);
        return bst.getArray();
    }
}
