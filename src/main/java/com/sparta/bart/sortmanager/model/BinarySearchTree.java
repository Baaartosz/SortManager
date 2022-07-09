package com.sparta.bart.sortmanager.model;

public class BinarySearchTree {

    Node root;
    int nodes = 0;
    int nodeIndex = 0;
    int[] sortedArray;

    public BinarySearchTree(int[] data){
        root = null;
        sortedArray = new int[data.length];
        for (int i : data) {
            insert(i);
            nodes++;
        }
    }
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int data) {
        //tree is empty
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data)
            root.left = insert_Recursive(root.left, data);
        else if (data > root.data)
            root.right = insert_Recursive(root.right, data);

        return root;
    }

    void inorder() {
        inorder_Recursive(root);
    }

    public int[] getArray(){
        inorder();
        return sortedArray;
    }

    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            sortedArray[nodeIndex] = root.data;
            nodeIndex++;
            inorder_Recursive(root.right);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
}
