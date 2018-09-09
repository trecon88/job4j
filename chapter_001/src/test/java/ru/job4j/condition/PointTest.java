package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenX10Y10X20Y25Then5() {
        int x1 = 0;
        int y1 = 0;
        Point firstPoint = new Point(x1, y1);
        int x2 = 0;
        int y2 = 5;
        Point secondPoint = new Point(x2, y2);

        double result = firstPoint.distanceTo(secondPoint);
        double expected = 5.0D;

        assertThat(result, closeTo(expected, 0.1));
    }

}