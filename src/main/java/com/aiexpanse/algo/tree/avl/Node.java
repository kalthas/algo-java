package com.aiexpanse.algo.tree.avl;

public class Node {

    public Node left;
    public Node right;
    public int value;
    public int height;

    public Node(int value) {
        this.value = value;
        this.height = 1;
    }


    public Node(int value, Node left, Node right) {
        this(value);
        this.left = left;
        this.right = right;
        this.reCalculateHeight();
    }

    public void setLeft(Node left) {
        this.left = left;
        this.reCalculateHeight();
    }

    public void setRight(Node right) {
        this.right = right;
        this.reCalculateHeight();
    }

    private void reCalculateHeight() {
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        String leftString = left == null ? "null" : Integer.toString(left.value);
        String rightString = right == null ? "null" : Integer.toString(right.value);
        return "Node[" + value + "]{" + leftString + "," + rightString + "}";
    }

}
