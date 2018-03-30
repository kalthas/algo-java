package com.aiexpanse.algo.tree.construction;

import com.aiexpanse.algo.tree.ThreadedNode;
import com.aiexpanse.algo.tree.ThreadedTreeBase;

import java.util.Stack;

public class InOrderThreaded extends ThreadedTreeBase<Integer> {

    public static void main(String[] args) {
        InOrderThreaded inOrderThreaded = new InOrderThreaded();
        inOrderThreaded.run();
    }

    private void run() {
        ThreadedNode<Integer> inOrderTree = createInOrderSeq(10, 1, IntGen);
        ThreadedNode<Integer> threadedTree = toRightThreaded(inOrderTree);
        inOrderTraverse(threadedTree);
    }

    private void inOrderTraverse(ThreadedNode<Integer> root) {
        if (root == null) {
            return;
        }
        root = leftMost(root);
        while (root != null) {
            print(root);
            if (root.rightThread) {
                root = root.right;
            } else {
                root = leftMost(root.right);
            }
        }
    }

    private ThreadedNode<Integer> leftMost(ThreadedNode<Integer> node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private ThreadedNode<Integer> toRightThreaded(ThreadedNode<Integer> root) {
        ThreadedNode<Integer> treeRoot = root;
        Stack<ThreadedNode<Integer>> stack = new Stack<>();
        while (root != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    ThreadedNode<Integer> successor = stack.pop();
                    root.right = successor;
                    root.rightThread = true;
                    root = successor.right;
                }
            }
        }
        return treeRoot;
    }

}
