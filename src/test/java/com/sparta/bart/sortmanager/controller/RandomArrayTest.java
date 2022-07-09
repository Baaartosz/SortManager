package com.sparta.bart.sortmanager.controller;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomArrayTest {

    RandomArray r;
    HashSet<Integer> knownInt;

    @BeforeEach
    void setUp() {
        r = new RandomArray();
        knownInt = new HashSet<Integer>();
    }

    boolean hasDuplicates(int[] array){
        boolean foundDuplicate = false;
        for (int j : array) {
            if(!knownInt.add(j)){
                foundDuplicate = true;
            }
        }
        return foundDuplicate;
    }


    @Test
    @DisplayName("int[500]")
    void testGenerateArray500() {
        Assertions.assertFalse(hasDuplicates(r.generateArray(500)));
    }

    @Test
    @DisplayName("int[5000]")
    void testGenerateArray5000() {
        Assertions.assertFalse(hasDuplicates(r.generateArray(5000)));
    }

    @Test
    @DisplayName("int[25000]")
    void testGenerateArray25000() {
        Assertions.assertFalse(hasDuplicates(r.generateArray(25000)));
    }

    @Test
    @DisplayName("int[50000]")
    void testGenerateArrayMillion() {
        Assertions.assertFalse(hasDuplicates(r.generateArray(200000)));
    }
}