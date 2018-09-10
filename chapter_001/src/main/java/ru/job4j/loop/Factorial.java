package ru.job4j.loop;

/**
 * Класс для подсчета факториала числа.
 */
public class Factorial {
    public int calc(int n) {
        int result;
        if (n <= 1) {
            result = 1;
        } else {
            result = n * calc(n - 1);
        }
        return result;
    }
}
