package com.aiexpanse.algo.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    @JsonIgnore
    public Node<T> left;
    @JsonIgnore
    public Node<T> right;
    @JsonIgnore
    public T value;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return value.toString();
    }

    public List<Node<T>> getChildren() {
        List<Node<T>> children = new ArrayList<>();
        if (left != null) {
            children.add(left);
        }
        if (right != null) {
            children.add(right);
        }
        return children;
    }

    @Override
    public String toString() {
        String valueString = value == null ? "null" : value.toString();
        String leftString = left == null ? "null" : left.value.toString();
        String rightString = right == null ? "null" : right.value.toString();
        return "Node[" + valueString + "]{" + leftString + "," + rightString + "}";
    }

}
