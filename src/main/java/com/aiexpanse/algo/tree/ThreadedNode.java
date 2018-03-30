package com.aiexpanse.algo.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ThreadedNode<T> {

    @JsonIgnore
    public ThreadedNode<T> left;
    @JsonIgnore
    public ThreadedNode<T> right;
    @JsonIgnore
    public T value;
    @JsonIgnore
    public boolean leftThread;
    @JsonIgnore
    public boolean rightThread;


    public ThreadedNode(T value) {
        this.value = value;
    }

    public ThreadedNode(T value, ThreadedNode<T> left, ThreadedNode<T> right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return value.toString();
    }

    public List<ThreadedNode<T>> getChildren() {
        List<ThreadedNode<T>> children = new ArrayList<>();
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
