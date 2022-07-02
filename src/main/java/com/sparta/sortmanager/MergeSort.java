package com.sparta.sortmanager;

public class MergeSort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int[] workArray = arrayToSort.clone();
        topDownSplitMerge(workArray, 0, arrayToSort.length, arrayToSort);
        return arrayToSort;
    }

    private void topDownSplitMerge(int B[], int iBegin, int iEnd, int A[]){
        if(iEnd - iBegin <= 1) return;
        int iMiddle = (iEnd + iBegin) / 2;

        topDownSplitMerge(A, iBegin, iMiddle, B);
        topDownSplitMerge(A, iMiddle, iEnd, B);

        topDownMerge(B, iBegin, iMiddle, iEnd, A);
    }

    private void topDownMerge(int B[], int iBegin, int iMiddle, int iEnd, int A[]){
        int i = iBegin;
        int j = iMiddle;

        for (int k = iBegin; k < iEnd; k++){
            if(i < iMiddle && (j >= iEnd || A[i] <= A[j])){
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
        }
    }

}
