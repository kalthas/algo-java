package com.aiexpanse.algo.tree.traversal;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

public class ThreadedInOrderTraversal extends TreeBase<Integer> {

    public static void main(String[] args) {
        ThreadedInOrderTraversal self = new ThreadedInOrderTraversal();
        Node<Integer> postOrderSeq = self.createPostOrderSeq(103, 1, IntGen);
        self.postOrderTraverse(postOrderSeq, IntPrint);
        self.serve(postOrderSeq);
    }

}
