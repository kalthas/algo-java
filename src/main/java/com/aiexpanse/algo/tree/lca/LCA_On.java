package com.aiexpanse.algo.tree.lca;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

import java.util.LinkedList;
import java.util.List;

public class LCA_On extends TreeBase<Integer> {

    public static void main(String[] args) {
        LCA_On self = new LCA_On();
        Node<Integer> postOrderSeq = self.createPostOrderSeq(10, 1, IntGen);
        Node lca = self.findLCA(postOrderSeq, 2, 4);
        print(lca);
        lca = self.findLCA(postOrderSeq, 3, 8);
        print(lca);
        lca = self.findLCA(postOrderSeq, 0, 8);
        print(lca);
    }

    /*
     * Algorithm complexity is O(n + n + h) = O(n)
     */
    private Node<Integer> findLCA(Node<Integer> root, Integer n1, Integer n2) {
        if (root == null) {
            return null;
        }
        List<Node<Integer>> path1 = new LinkedList<>();
        List<Node<Integer>> path2 = new LinkedList<>();
        if (findLCA(root, n1, path1) && findLCA(root, n2, path2)) {
            Node<Integer> LCA = root;
            for (int i=0; ; i++) {
                if (path1.get(i) == path2.get(i)) {
                    LCA = path1.get(i);
                } else {
                    break;
                }
            }
            return LCA;
        } else {
            return null;
        }
    }

    private boolean findLCA(Node<Integer> root, Integer n, List<Node<Integer>> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.value.equals(n)) {
            return true;
        }
        if (findLCA(root.left, n, path) || findLCA(root.right, n, path)) {
            return true;
        }
        path.remove(root);
        return false;
    }

}
