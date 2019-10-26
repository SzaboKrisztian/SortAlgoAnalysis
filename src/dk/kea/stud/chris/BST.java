package dk.kea.stud.chris;

import java.util.ArrayList;
import java.util.List;

public class BST {
    List<Integer> sorted;
    long NoOps;

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node root;

    BST() {
        root = null;
        NoOps = 0;
    }

    private void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            NoOps++;
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            NoOps++;
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public List<Integer> getSorted() {
        sorted = new ArrayList<>();
        inorderRec(root);
        return sorted;
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            sorted.add(root.key);
            inorderRec(root.right);
        }
    }

    public void treeIns(List<Integer> arr) {
        for (int i: arr) {
            insert(i);
        }
    }
}
