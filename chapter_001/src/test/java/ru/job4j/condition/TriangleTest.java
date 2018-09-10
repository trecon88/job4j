package ru.job4j.condition;

import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
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

    @Test
    public void  whenCoordAEqCoordBThenCheckEqCoordFalse() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(4, 0);
        Triangle triangle = new Triangle(a, b, c);

        boolean result = triangle.checkEqCoord();
        boolean expected = true;

        assertThat(result, is(expected));
    }

    @Test
    public void whenABplusBCEqACThenCheckOneLineTrue() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(0, 2);
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        Triangle triangle = new Triangle(a, b, c);

        boolean result = triangle.checkOneLine(ab, ac, bc);
        boolean expected = true;

        assertThat(result, is(expected));
    }


}