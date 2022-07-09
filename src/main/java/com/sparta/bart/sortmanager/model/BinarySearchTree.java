package com.sparta.bart.sortmanager.model;

public class BinarySearchTree {

    Node root;
    int nodes = 0;
    int nodeIndex = 0;
    int[] sortedArray;

    public BinarySearchTree(int[] data){
        root = null;
        sortedArray = new int[data.length];
        for (int i: data) {
            insert(i);
            nodes++;
        }
    }

    // FIXME getting duplicate values meaning that when BST processes them they get removed leading to data that is not correct.
    // TODO implement a new random fill method to add random integers without duplicates.

    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int data) {
        //tree is empty
        if (root == null) {
            root = new Node(data);
            return root;
        }
        //traverse the tree
        if (data < root.data)     //insert in the left subtree
            root.left = insert_Recursive(root.left, data);
        else if (data > root.data)    //insert in the right subtree
            root.right = insert_Recursive(root.right, data);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);
    }

    public int[] getArray(){
        inorder();
        return sortedArray;
    }

    // recursively traverse the BST
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
