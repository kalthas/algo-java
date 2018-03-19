package com.aiexpanse.algo.lintcode.lint33;

import java.util.List;

public class Lint33 {

    public static void main(String[] args) {
        SolutionForCount solutionForCount = new SolutionForCount();
        int count = solutionForCount.solveNQueens(5);
        System.out.println(count);

        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(5);
        for (int i=0; i<lists.size(); i++) {
            System.out.println("Solution" + (i + 1));
            lists.get(i).forEach(line -> System.out.println(" " + line));
        }
    }

}
