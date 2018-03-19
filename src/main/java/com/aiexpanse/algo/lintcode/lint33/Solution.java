package com.aiexpanse.algo.lintcode.lint33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Use three sets to record invalid places
 *    | | |                / / /             \ \ \
 *    O O O               O O O               O O O
 *    | | |              / / / /             \ \ \ \
 *    O O O               O O O               O O O
 *    | | |              / / / /             \ \ \ \
 *    O O O               O O O               O O O
 *    | | |              / / /                 \ \ \
 *   3 columns        5 45° diagonals     5 135° diagonals    (when n is 3)
 */
public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */

    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> colOccupation = new HashSet<>();
        HashSet<Integer> ltrOccupation = new HashSet<>(); // left-to-right diagonal
        HashSet<Integer> rtlOccupation = new HashSet<>(); // right-to-left diagonal
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] bRow : board) {
            Arrays.fill(bRow, '.');
        }
        solve(n, 0, board, result, colOccupation, ltrOccupation, rtlOccupation);
        return result;
    }

    private void solve(int n, int row, char[][] board, List<List<String>> result, HashSet<Integer> colOccupation, HashSet<Integer> ltrOccupation, HashSet<Integer> rtlOccupation) {
        if (row == n) {
            List<String> oneSolution = new ArrayList<>();
            for (char[] bRow : board) {
                oneSolution.add(new String(bRow));
            }
            result.add(oneSolution);
        }
        for (int col=0; col<n; col++) {
            if (!colOccupation.contains(col) && !rtlOccupation.contains(col+row) && !ltrOccupation.contains(n-1-row+col)) {
                board[col][row] = 'Q';
                colOccupation.add(col);
                rtlOccupation.add(col+row);
                ltrOccupation.add(n-1-row+col);
                solve(n, row+1, board, result, colOccupation, ltrOccupation, rtlOccupation);
                board[col][row] = '.';
                colOccupation.remove(col);
                rtlOccupation.remove(col+row);
                ltrOccupation.remove(n-1-row+col);
            }
        }
    }

}