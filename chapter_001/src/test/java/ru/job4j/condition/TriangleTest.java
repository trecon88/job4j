package ru.job4j.condition;

import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, IsCloseTo.closeTo(expected, 0.1));
    }
    @Test
    public void whenPeriodSetThreePointsThenTrianglePeriod() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(4, 0);
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.period(ab, ac, bc);
        double expected = 6D;
        assertThat(result, IsCloseTo.closeTo(expected, 0.1));
    }
}