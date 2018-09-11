package ru.job4j.loop;

/**
 * Класс для подсчета факториала числа.
 */
public class Factorial {
    /**
     * Метод вычисляет факториал числа.
     * @param number Число.
     * @return Факториал.
     */
    public int calc(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
