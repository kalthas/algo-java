package com.aiexpanse.algo.leetcode.lc149;

class Solution {
    public int maxPoints(Point[] points) {
        return 0;
    }
    private boolean isCollinear(Point p0, Point p1, Point p2) {
        return ((p1.x-p0.x)*(p2.y-p0.y)-(p1.y-p0.y)*(p2.x-p0.x)) == 0;
    }
}
