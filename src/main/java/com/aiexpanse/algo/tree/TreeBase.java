package com.aiexpanse.algo.tree;

import com.aiexpanse.algo.jetty.UIAware;

public abstract class TreeBase<T> extends UIAware {

    protected void serve(Node<T> tree) {
        super.serve("/tree", tree);
    }

    public interface NodeValueGenerator<T> {
        T next(T current);
    }

    public interface NodeVisitor<T> {
        void visit(Node<T> node);
    }

    protected static NodeValueGenerator<Integer> IntGen = (current) -> ++current;
    protected static NodeVisitor<Integer> IntPrint = TreeBase::print;

    public static void print(Node node) {
        System.out.println(node);
    }

    public Node<T> create(T value) {
        return new Node<>(value);
    }

    public Node<T> create(T value, Node<T> left) {
        Node<T> node = create(value);
        node.left = left;
        return node;
    }

    public Node<T> create(T value, Node<T> left, Node<T> right) {
        Node<T> node = create(value, left);
        node.right = right;
        return node;
    }

    public Node<T> createPostOrderSeq(int n, T initial, NodeValueGenerator<T> gen) {
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return create(initial);
        } else if (n == 2) {
            Node<T> left = create(initial);
            return create(gen.next(initial), left);
        }
        /*
         * allocate as many nodes as possible to left sub tree
         */
        int leftHalf = leftMax(n),
                rightHalf = n-leftHalf-1;
        Node<T> leftRoot = createPostOrderSeq(leftHalf, initial, gen);
        Node<T> rightRoot = createPostOrderSeq(rightHalf, gen.next(leftRoot.value), gen);
        return create(gen.next(rightRoot.value), leftRoot, rightRoot);
    }

    public void postOrderTraverse(Node<T> node, NodeVisitor<T> visitor) {
        if (node != null) {
            postOrderTraverse(node.left, visitor);
            postOrderTraverse(node.right, visitor);
            visitor.visit(node);
        }
    }

    public void inOrderTraverse(Node<T> node, NodeVisitor<T> visitor) {
        if (node != null) {
            inOrderTraverse(node.left, visitor);
            visitor.visit(node);
            inOrderTraverse(node.right, visitor);
        }
    }

    /*
     * The upper bound of number of nodes that can be allocated to left sub tree given total
     * node number n
     */
    private static int leftMax(int n) {
        int subDepth = (int) Math.floor(log2(n)-1);
        int maxSubDepth = (int)Math.pow(2, subDepth + 1)-1;
        int maxSubDepthM1 = (int)Math.pow(2, subDepth)-1;
        if ((n - 1 - maxSubDepth) < maxSubDepthM1) {
            return n - 1 - maxSubDepthM1;
        } else {
            return maxSubDepth;
        }
    }

    private static int log2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

}
