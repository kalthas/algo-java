package com.aiexpanse.algo.tree.traversal;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

public class InOrderTraversal extends TreeBase<Integer> {

    public static void main(String[] args) {
        InOrderTraversal self = new InOrderTraversal();
        Node<Integer> inOrderSeq = self.createInOrderSeq(10, 1, IntGen);
        self.inOrderTraverse(inOrderSeq, IntPrint);
        self.serve(inOrderSeq);
    }

}
