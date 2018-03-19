package com.aiexpanse.algo.leetcode.lc94;

import java.lang.reflect.Method;
import java.util.List;

public class LC94 {

    public static void main(String[] args) {
        // [1,null,2,3],
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;

        test(Solution.class, n1);
    }

    private static void test(Class<?> solutionCls, TreeNode root) {
        try {
            Object solution = solutionCls.newInstance();
            Method inorderTraversal = solutionCls.getMethod("inorderTraversal", TreeNode.class);
            List<Integer> result = (List<Integer>) inorderTraversal.invoke(solution, root);
            result.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
