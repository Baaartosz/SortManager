package com.sparta.sortmanager;

public class MergeSort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if(arrayToSort == null) return new int[] {};

        int[] workArray = arrayToSort.clone();
        topDownSplitMerge(workArray, 0, arrayToSort.length, arrayToSort);

        return workArray;
    }

    private void topDownSplitMerge(int B[], int indexBegin, int indexEnd, int A[]){
        if(indexEnd - indexBegin <= 1) return;
        int iMiddle = (indexEnd + indexBegin) / 2;

        topDownSplitMerge(A, indexBegin, iMiddle, B);
        topDownSplitMerge(A, iMiddle, indexEnd, B);

        topDownMerge(B, indexBegin, iMiddle, indexEnd, A);
    }

    private void topDownMerge(int B[], int indexBegin, int indexMiddle, int indexEnd, int A[]){
        int i = indexBegin;
        int j = indexMiddle;

        for (int k = indexBegin; k < indexEnd; k++){
            if(i < indexMiddle && (j >= indexEnd || A[i] <= A[j])){
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
        }
    }

}
