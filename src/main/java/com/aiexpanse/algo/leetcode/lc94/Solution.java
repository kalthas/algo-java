package com.aiexpanse.algo.leetcode.lc94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                result.add(current.val);
                root = current.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return result;
    }
}
