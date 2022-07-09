package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.model.sorters.BinarySort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySortTest {
    BinarySort binarySort;

    @BeforeEach
    void setup(){
        binarySort = new BinarySort();
    }

    @Test
    @DisplayName("null")
    void nullTest(){
        Assertions.assertNotNull(binarySort.sortArray(null));
    }

    @Test
    @DisplayName("int[0]")
    void sortEmpty() {
        var a = new TestArrayGenerator(0);
        Assertions.assertArrayEquals(a.getSorted(), binarySort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[5]")
    void sortSmall() {
        var a = new TestArrayGenerator(5);
        Assertions.assertArrayEquals(a.getSorted(), binarySort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[500]")
    void sortLarge() {
        var a = new TestArrayGenerator(500);
        Assertions.assertArrayEquals(a.getSorted(), binarySort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[2500] ")
    void sortExtreme() {
        var a = new TestArrayGenerator(2500);
        Assertions.assertArrayEquals(a.getSorted(), binarySort.sortArray(a.getUnsorted()));
    }
}