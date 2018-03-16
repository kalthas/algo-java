package com.aiexpanse.algo.tree.traversal;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

public class PostOrderTraversal extends TreeBase<Integer> {

    public static void main(String[] args) {
        PostOrderTraversal self = new PostOrderTraversal();
        Node<Integer> postOrderSeq = self.createPostOrderSeq(103, 1, IntGen);
        self.postOrderTraverse(postOrderSeq, IntPrint);
        self.serve(postOrderSeq);
    }

}
