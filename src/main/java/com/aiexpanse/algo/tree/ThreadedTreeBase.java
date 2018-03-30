package com.aiexpanse.algo.tree;

import com.aiexpanse.algo.jetty.UIAware;

import java.util.stream.IntStream;

public abstract class ThreadedTreeBase<T> extends UIAware {

    protected void serve(ThreadedNode<T> tree) {
        super.serve("/tree", tree);
    }

    public interface ThreadedNodeValueGenerator<T> {
        T next(T current);
    }

    public interface ThreadedNodeVisitor<T> {
        void visit(ThreadedNode<T> node);
    }

    protected static ThreadedNodeValueGenerator<Integer> IntGen = (current) -> ++current;
    protected static ThreadedNodeVisitor<Integer> IntPrint = ThreadedTreeBase::print;

    public static void print(ThreadedNode node) {
        System.out.println(node);
    }

    public ThreadedNode<T> create(T value) {
        return new ThreadedNode<>(value);
    }

    public ThreadedNode<T> create(T value, ThreadedNode<T> left) {
        ThreadedNode<T> node = create(value);
        node.left = left;
        return node;
    }

    public ThreadedNode<T> create(T value, ThreadedNode<T> left, ThreadedNode<T> right) {
        ThreadedNode<T> node = create(value, left);
        node.right = right;
        return node;
    }

    public ThreadedNode<T> createPostOrderSeq(int n, T initial, ThreadedNodeValueGenerator<T> gen) {
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return create(initial);
        } else if (n == 2) {
            ThreadedNode<T> left = create(initial);
            return create(gen.next(initial), left);
        }
        /*
         * allocate as many nodes as possible to left sub tree
         */
        int leftHalf = leftMax(n),
                rightHalf = n-leftHalf-1;
        ThreadedNode<T> leftRoot = createPostOrderSeq(leftHalf, initial, gen);
        ThreadedNode<T> rightRoot = createPostOrderSeq(rightHalf, gen.next(leftRoot.value), gen);
        return create(gen.next(rightRoot.value), leftRoot, rightRoot);
    }

    public ThreadedNode<T> createInOrderSeq(int n, T initial, ThreadedNodeValueGenerator<T> gen) {
        T[] valueArray = (T[])new Object[n];
        valueArray[0] = initial;
        IntStream.range(1, n).forEach(i -> valueArray[i] = gen.next(valueArray[i-1]));
        return toInOrder(valueArray, 0, n-1);
    }

    private ThreadedNode<T> toInOrder(T[] values, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new ThreadedNode<>(values[left]);
        } else {
            int mid = left + (right-left)/2;
            ThreadedNode<T> leftRoot = toInOrder(values, left, mid - 1);
            ThreadedNode<T> rightRoot = toInOrder(values, mid + 1, right);
            return new ThreadedNode<>(values[mid], leftRoot, rightRoot);
        }
    }

    public void postOrderTraverse(ThreadedNode<T> node, ThreadedNodeVisitor<T> visitor) {
        if (node != null) {
            postOrderTraverse(node.left, visitor);
            postOrderTraverse(node.right, visitor);
            visitor.visit(node);
        }
    }

    public void inOrderTraverse(ThreadedNode<T> node, ThreadedNodeVisitor<T> visitor) {
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
