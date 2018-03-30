package com.aiexpanse.algo.tree.avl;

public class Tree {

    int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    boolean isBalanced(Node left, Node right) {
        return Math.abs(getHeight(left) - getHeight(right)) < 2;
    }

    boolean isLeftHigher(Node node) {
        return getHeight(node.left) - getHeight(node.right) > 0;
    }

    Node insert(Node root, int value) {
        if (root != null) {
            if (value < root.value) {
                Node newLeft;
                if (root.left == null) {
                    newLeft = new Node(value);
                } else {
                    newLeft = insert(root.left, value);
                }
                if (isBalanced(newLeft, root.right)) {
                    root.setLeft(newLeft);
                    return root;
                } else {
                    root.setLeft(newLeft);
                    if (isLeftHigher(newLeft)) {
                        return singleLeftRotate(root);
                    } else {
                        return doubleLeftRotate(root);
                    }
                }
            } else if (value > root.value) {
                Node newRight;
                if (root.right == null) {
                    newRight = new Node(value);
                } else {
                    newRight = insert(root.right, value);
                }
                if (isBalanced(root.left, newRight)) {
                    root.setRight(newRight);
                    return root;
                } else {
                    root.setRight(newRight);
                    if (isLeftHigher(newRight)) {
                        return doubleRightRotate(root);
                    } else {
                        return singleRightRotate(root);
                    }
                }
            }
        }
        return null;
    }

    /*
     * (?) represents tree with height h, (?+) represents tree with height h+1
     *
     *        (r)
     *       /   \
     *     (b)   (?)
     *     / \
     *  (?+) (c)
     *
     *  converts to
     *
     *         (b)
     *        /   \
     *      (?+)  (r)
     *            / \
     *          (c) (?)
     */
    private Node singleLeftRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    /*
     *         (r)
     *        /   \
     *      (b)   (?)
     *      / \
     *    (?) (c)
     *        / \
     *      (v) (w)
     *
     *   converts to
     *
     *         (c)
     *        /   \
     *     (b)    (r)
     *     / \    / \
     *   (?) (v) (w) (?)
     *
     */
    private Node doubleLeftRotate(Node root) {
        Node b = root.left;
        Node c = b.right;
        Node v = c.left;
        Node w = c.right;
        b.right = v;
        c.left = b;
        root.left = w;
        c.right = root;
        return c;
    }

    /*
     * (?) represents tree with height h, (?+) represents tree with height h+1
     *
     *        (r)
     *       /   \
     *     (?)   (b)
     *           / \
     *         (c) (?+)
     *
     *  converts to
     *
     *         (b)
     *        /   \
     *      (r)   (?+)
     *      / \
     *    (?) (c)
     */
    private Node singleRightRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    /*
     *         (r)
     *        /   \
     *      (?)   (b)
     *            / \
     *          (c) (?)
     *          / \
     *        (v) (w)
     *
     *   converts to
     *
     *         (c)
     *        /   \
     *     (r)    (b)
     *     / \    / \
     *   (?) (v) (w) (?)
     *
     */
    private Node doubleRightRotate(Node root) {
        Node b = root.right;
        Node c = b.left;
        Node v = c.left;
        Node w = c.right;
        root.right = v;
        b.left = w;
        c.right = b;
        c.left = root;
        return c;
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.run();
    }

    private void run() {
        Node node = new Node(5);
        node = insert(node, 7);
        node = insert(node, 10);
        node = insert(node, 3);
        node = insert(node, 8);
        node = insert(node, 2);
        inOrderTraverse(node);
    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.println(node);
            inOrderTraverse(node.right);
        }
    }

}
