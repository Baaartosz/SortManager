package com.sparta.sortmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergerArrayTest {

    @Test
    void merge() {
        MergerArray m = new MergerArray();

        int[] foo = { 3, 7 };
        int[] bar = { 4, 8, 11 };
        int[] merged = { 3, 4, 7, 8, 11 };

        Assertions.assertArrayEquals(merged, m.merge(foo, bar));
    }
}