package com.sparta.bart.sortmanager.model.sorters;

import com.sparta.bart.sortmanager.model.Sorter;

public class MergeSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort == null) return new int[] {-1};

        int[] workArray = arrayToSort.clone();
        topDownSplitMerge(workArray, 0, arrayToSort.length, arrayToSort);

        return workArray;
    }

    private void topDownSplitMerge(int[] B, int indexBegin, int indexEnd, int[] A){
        if(indexEnd - indexBegin <= 1) return;
        int iMiddle = (indexEnd + indexBegin) / 2;

        topDownSplitMerge(A, indexBegin, iMiddle, B);
        topDownSplitMerge(A, iMiddle, indexEnd, B);

        topDownMerge(B, indexBegin, iMiddle, indexEnd, A);
    }

    private void topDownMerge(int[] B, int indexBegin, int indexMiddle, int indexEnd, int[] A){
        int i = indexBegin;
        int j = indexMiddle;

        for (int mergeIndex = indexBegin; mergeIndex < indexEnd; mergeIndex++){
            // if ( i LESS THEN indexMiddle AND
            // (j IS GREATER THEN indexEnd OR arrayA[i] <= arrayA[j])
            if(i < indexMiddle && (j >= indexEnd || A[i] <= A[j])){
                B[mergeIndex] = A[i];
                i++;
            } else {
                B[mergeIndex] = A[j];
                j++;
            }
        }
    }

}
