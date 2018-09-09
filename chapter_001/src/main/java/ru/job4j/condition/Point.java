package ru.job4j.condition;
/**
 * Определение точки в двумерной системе координат.
 * @author contre
 * @version $Id$
 * @since 0.1
 */
public class Point {
    /**
     * Координата точки на оси x.
     */
    private int x;
    /**
     * Координата точки на оси y.
     */
    private int y;

    /**
     * Конструктор с определением x и y.
     * @param x координаты на оси x.
     * @param y координаты на оси y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод рассчета расстояния между двумя точками.
     * @param that Точка до которой необходимо определить расстояние.
     * @return Расстояние.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

}
