package ru.job4j.max;

/**
 * Класс для определения наибольшего из чисел.
 * @author contre
 */
public class Max {
    /**
     * Определение наибольшего из двух чисeл.
     * @param first первое число.
     * @param second второе число.
     * @return наибольшее число.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Определение наибольшего из трех чисел.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return наибольшее число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
