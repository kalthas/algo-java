package com.aiexpanse.algo.tree.lca;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;
import com.aiexpanse.algo.util.Pair;

public class LCA_Oh extends TreeBase<Integer> {

    public static void main(String[] args) {
        LCA_Oh self = new LCA_Oh();
        Node<Integer> postOrderSeq = self.createPostOrderSeq(10, 1, IntGen);
        Node lca = self.findLCA(postOrderSeq, 2, 4);
        print(lca);
        lca = self.findLCA(postOrderSeq, 3, 8);
        print(lca);
        lca = self.findLCA(postOrderSeq, 0, 8);
        print(lca);
    }

    /*
     * Algorithm complexity is O(h)
     */
    private Node<Integer> findLCA(Node<Integer> root, Integer n1, Integer n2) {
        Pair<Boolean, Boolean> bothFound = new Pair<>(false, false);
        Node<Integer> lca = findLCA(root, n1, n2, bothFound);
        if (bothFound.getLeft() && bothFound.getRight()) {
            return lca;
        }
        return null;
    }

    private Node<Integer> findLCA(Node<Integer> root, Integer n1, Integer n2, Pair<Boolean, Boolean> bothFound) {
        if (root == null) {
            return null;
        }
        if (root.value.equals(n1)) {
            bothFound.setLeft(true);
            return root;
        }
        if (root.value.equals(n2)) {
            bothFound.setRight(true);
            return root;
        }
        Node<Integer> left = findLCA(root.left, n1, n2, bothFound);
        if (left != null) {
            if (bothFound.getLeft() && bothFound.getRight()) {
                return root.left;
            }
        }
        Node<Integer> right = findLCA(root.right, n1, n2, bothFound);
        if (right != null) {
            if (bothFound.getLeft() && bothFound.getRight()) {
                return root.right;
            }
        }
        if (bothFound.getLeft() && bothFound.getRight()) {
            return root;
        }
        return null;
    }

}
