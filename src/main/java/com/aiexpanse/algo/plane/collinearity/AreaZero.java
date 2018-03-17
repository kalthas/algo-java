package com.aiexpanse.algo.plane.collinearity;

import com.aiexpanse.algo.plane.Point;

public class AreaZero {

    public static void main(String[] args) {
        Point p_0_0 = new Point(0, 0);
        Point p_0_1 = new Point(0, 1);
        System.out.println(isCollinear(p_0_0, p_0_0, p_0_1));
        Point p_1_0 = new Point(1, 0);
        System.out.println(isCollinear(p_0_0, p_0_0, p_1_0));
        System.out.println(isCollinear(p_0_0, p_0_1, p_1_0));
    }

    /*
     * If area of the triangle composed of three points is zero, then the
     * three points is collinear
     *
     *  y
     *  |            A(x1, y1)
     *  |
     *  |
     *  |
     *  |
     *  |    B(x2, y2)         C(x3, y3)
     *  |
     *  +---------------------------------> x
     *
     *  Area of ABC is 1/2(CBxAB) where CB = (x3-x2, y3-y2), and AB = (x1-x2,y1-y2)
     *  CBxAB =
     *  | x3-x2 y3-y2 |
     *  | x1-x2 y1-y2 | = (x3-x2)*(y1-y2) - (y3-y2)*(x1-x2)
     *  The sign is not a concern because we care only about area in this question.
     *  (in geometry sign represents direction (z, or -z) of the cross product, and
     *  area represents quantity of the cross product)
     */
    public static boolean isCollinear(Point a, Point b, Point c) {
        return ((c.x-b.x)*(a.y-b.y) - (c.y-b.y)*(a.x-b.x)) == 0;
    }

}
