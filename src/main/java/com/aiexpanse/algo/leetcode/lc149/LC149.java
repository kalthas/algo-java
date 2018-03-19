package com.aiexpanse.algo.leetcode.lc149;

public class LC149 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Point[] points = new Point[5];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(0, 2);
        points[3] = new Point(1, 0);
        points[4] = new Point(2, 0);
        int maxPoints = solution.maxPoints(points);
        System.out.println(maxPoints);
    }
}
