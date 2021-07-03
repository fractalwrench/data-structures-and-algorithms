package co.uk.fractalwrench.dsaa.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A custom implementation of a binary search tree. This tree consists of a maximum of two branches on each level,
 * where the left-most node always contains the lowest value. This makes BSTs good for searching large data sets.
 * <p></p>
 * This BST does _not_ allow the insertion of duplicate values, and does not attempt any balancing.
 * <p></p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with concurrent modifications for example.
 * <table>
 * <td>
 *     <tr>Indel:  O(logn)</tr>
 *     <tr>Search: O(logn)</tr>
 *     <tr>Space:  O(n)</tr>
 * </td>
 * </table>
 */
public class BinarySearchTree {

    private Node root;

    /**
     * Adds an element to the binary search tree.
     *
     * @param element the element.
     */
    public void add(int element) {
        // 1. go depth-first down the branch which matches the value. e.g.
        // if the value is less than root we should go left, otherwise we should go right.
        // once a terminal node is found the branch can be added.
        root = insertElement(root, element);
    }

    private Node insertElement(Node current, int element) {
        if (current == null) {
            return new Node(element);
        }

        if (element < current.value) { // go down the left branch
            current.left = insertElement(current.left, element);
        } else if (element > current.value) { // go down the right branch
            current.right = insertElement(current.right, element);
        } else {
            throw new IllegalStateException("Duplicate detected " + element);
        }
        return current;
    }

    /**
     * @return the minimum value stored in the BST.
     */
    public int getMinimum() {
        if (root == null) {
            throw new IllegalStateException();
        }
        return visitMinValue(root);
    }

    private int visitMinValue(Node node) {
        if (node.left != null) {
            return visitMinValue(node.left);
        } else {
            return node.value;
        }
    }

    /**
     * @return the maximum value stored in the BST.
     */
    public int getMaximum() {
        if (root == null) {
            throw new IllegalStateException();
        }
        return visitMaxValue(root);
    }

    private int visitMaxValue(Node node) {
        if (node.right != null) {
            return visitMaxValue(node.right);
        } else {
            return node.value;
        }
    }

    /**
     * @return the binary search tree nodes as a List, in the order of a depth-first-search.
     */
    public List<Integer> createSortedList() {
        if (root == null) {
            return Collections.emptyList();
        }

        // perform depth-first search by starting with the root
        List<Integer> sortedList = new ArrayList<>();
        depthFirstSearch(root, sortedList);
        return sortedList;
    }

    private void depthFirstSearch(Node node, List<Integer> list) {
        if (node != null) {
            depthFirstSearch(node.left, list);
            list.add(node.value);
            depthFirstSearch(node.right, list);
        }
    }


    private static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }
}
