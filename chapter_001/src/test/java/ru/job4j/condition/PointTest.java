package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenX10Y10X20Y25Then5() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(0, 5);
        double result = firstPoint.distanceTo(secondPoint);
        double expected = 5.0D;
        assertThat(result, closeTo(expected, 0.1));
    }
    @Test
    public void whenThisCoordEqThatCoordThenTrue() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(0, 0);
        boolean result = firstPoint.eqCoord(secondPoint);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}