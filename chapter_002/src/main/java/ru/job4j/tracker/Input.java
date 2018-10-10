package ru.job4j.tracker;

/**
 * Интерфейс ввода/вывода данных
 */
public interface Input {
    /**
     * Метод задающий вопрос.
     * @param question Вопрос.
     * @return Ответ.
     */
    String ask(String question);

    int ask(String question, int[] range);
}
