package ru.job4j.max;

/**
 * Класс для определения наибольшего из двух чисел.
 * @author contre
 */
public class Max {
    /**
     * Определение наибольшего числа.
     * @param first первое число.
     * @param second второе число.
     * @return наибольшее число.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}
