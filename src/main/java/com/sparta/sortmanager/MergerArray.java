package com.sparta.sortmanager;

public class MergerArray {

    public int[] merge(int[] a, int[] b){
        int[] merged = new int[a.length + b.length];
        int aPosition = 0;
        int bPosition = 0;
        int mPosition = 0;

        // Compare both arrays against each other and pick the smallest value.
        while(aPosition < a.length && bPosition < b.length){
            if(a[aPosition] < b[bPosition]){
                merged[mPosition++] = a[aPosition++];
            } else {
                merged[mPosition++] = b[bPosition++];
            }
        }

        // Once one array has reached its end.
        // Iterate over the remaining array for the remainder of the merge array.
        while(aPosition < a.length){
            merged[mPosition++] = a[aPosition++];
        }

        while(bPosition < b.length){
            merged[mPosition++] = b[bPosition++];
        }

        return merged;
    }
}
