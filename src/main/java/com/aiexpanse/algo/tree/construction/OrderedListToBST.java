package com.aiexpanse.algo.tree.construction;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

import java.util.stream.IntStream;

public class OrderedListToBST extends TreeBase<Integer> {

    public static void main(String[] args) {
        OrderedListToBST orderedListToBST = new OrderedListToBST();
        orderedListToBST.run();
    }

    private void run() {
        Integer i = 5;
        synchronized (i) {
            try {
                i.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] ints = IntStream.rangeClosed(1, 20).toArray();
        Node<Integer> node = toBST(ints, 0, ints.length - 1);
        inOrderTraverse(node, IntPrint);
        serve(node);
    }

    private Node<Integer> toBST(int[] ints, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new Node<>(ints[left]);
        } else {
            int mid = left + (right-left)/2;
            Node<Integer> leftRoot = toBST(ints, left, mid - 1);
            Node<Integer> rightRoot = toBST(ints, mid + 1, right);
            return new Node<>(ints[mid], leftRoot, rightRoot);
        }
    }

}
