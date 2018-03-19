package com.aiexpanse.algo.lintcode.lint33;

/*
 * This solution can solve solutions count neatly, but is not good at
 * recording all possible solutions.
 */
public class SolutionForCount {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */

    private int count;

    public int solveNQueens(int n) {
        // write your code here
        int complete = (int)(Math.pow(2, n) - 1);
        recursiveChecker(complete, 0, 0, 0);
        return count;
    }

    private void recursiveChecker(int complete, int colCheck, int ltrCheck, int rtlCheck) {
        if (colCheck == complete) {
            count++;
            return;
        }
        int possiblePlaces = ~(colCheck | ltrCheck | rtlCheck);
        while ((possiblePlaces & complete) != 0) {
            int currentPick = possiblePlaces & -possiblePlaces;
            possiblePlaces -= currentPick;
            int nextLtrCheck = (ltrCheck | currentPick) >> 1;
            int nextRtlCheck = (rtlCheck | currentPick) << 1;
            int nextColCheck = currentPick | colCheck;
            recursiveChecker(complete, nextColCheck, nextLtrCheck, nextRtlCheck);
        }
    }

}