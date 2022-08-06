package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    double x1, x2;
    double y1, y2;
    double x3, x4;
    double y3, y4;

    Point start, end;

    public Segment(Point start, Point end) {
        if (start == null && end == null || start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException("null");
        }

        this.start = start;
        this.end = end;

        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }

    double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    Point middle() {
        return new Point((x1 + x2) / 2, (y1 + y2) / 2);
    }

    Point intersection(Segment another) {
        x3 = another.start.getX();
        x4 = another.end.getX();
        y3 = another.start.getY();
        y4 = another.end.getY();

        if (start == end)
            return null;
        else {
            double p1 = ((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4));
            double p2 = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
            double p = p1 / p2;

            double q1 = ((x1 - x3) * (y1 - y2)) - ((y1 - y3) * (x1 - x2));
            double q2 = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
            double q = q1 / q2;

            if ((p >= 0.0 && p <= 1.0) && (q >= 0.0 && q <= 1.0)) {
                double x = x1 + (p * (x2 - x1));
                double y = y1 + (p * (y2 - y1));
                return new Point(x, y);
            } else {
                return null;
            }
        }
    }
}
