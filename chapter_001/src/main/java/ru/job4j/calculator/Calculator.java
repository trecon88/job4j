package ru.job4j.calculator;

/**
 * Класс простейшего калькулятора.
 * @author contre
 * @since 08.09.2018
 * @version 1
 */
public class Calculator {
    double result;

    /**
     * Method add сложение первого числа со вторым.
     * @param first - первое число.
     * @param second - второе чилсо.
     */
    void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract вычитание второго числа из первого.
     * @param first - первое число.
     * @param second - второе число.
     */
    void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div деление первого числа на второе.
     * @param first - первое число.
     * @param second - второе число.
     */
    void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple умножение первого числа на второе.
     * @param first - первое число.
     * @param second - второе число.
     */
    void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult
     * @return - возвращает результат операций
     */
    double getResult() {
        return this.result;
    }
}


