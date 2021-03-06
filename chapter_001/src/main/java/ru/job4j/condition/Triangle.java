package ru.job4j.condition;

/**
 * Класс описывающий треугольник.
 */
public class Triangle {
    /**
     * Первая вершина.
     */
    private Point a;
    /**
     * Вторая вершина.
     */
    private Point b;
    /**
     * Третья вершина.
     */
    private Point c;
    /**
     * Конструктор с определением всех вершин.
     * @param a Первая вершина.
     * @param b Вторая вершина.
     * @param c Третья вершина.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод вычисления полупериметра по длинам сторон.
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Периметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(
                    p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return rsl;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return если люба из проверо true, то возвращает false - не треугольник
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }
}