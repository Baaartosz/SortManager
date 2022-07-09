package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.model.sorters.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BubbleTest {

    BubbleSort bubbleSort;
    @BeforeEach
    void setup(){
        bubbleSort = new BubbleSort();
    }

    @Test
    @DisplayName("null")
    void nullTest(){
        Assertions.assertNotNull(bubbleSort.sortArray(null));
    }

    @Test
    @DisplayName("int[0]")
    void sortEmpty() {
        var a = new TestArrayGenerator(0);
        Assertions.assertArrayEquals(a.getSorted(), bubbleSort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[5]")
    void sortSmall() {
        var a = new TestArrayGenerator(5);
        Assertions.assertArrayEquals(a.getSorted(), bubbleSort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[500]")
    void sortLarge() {
        var a = new TestArrayGenerator(500);
        Assertions.assertArrayEquals(a.getSorted(), bubbleSort.sortArray(a.getUnsorted()));
    }

    @Test
    @DisplayName("int[2500] ")
    void sortExtreme() {
        var a = new TestArrayGenerator(2500);
        Assertions.assertArrayEquals(a.getSorted(), bubbleSort.sortArray(a.getUnsorted()));
    }
}