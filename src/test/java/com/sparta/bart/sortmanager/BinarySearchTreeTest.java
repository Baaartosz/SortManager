package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.model.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @Test
    void getTree() {
        //System.out.println(Arrays.toString(small));
        var a = new TestArrayGenerator(250);
        bst = new BinarySearchTree(a.getUnsorted());
        Assertions.assertArrayEquals(a.getSorted(), bst.getArray());
    }
}