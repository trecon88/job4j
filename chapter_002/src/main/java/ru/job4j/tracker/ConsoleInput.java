package ru.job4j.tracker;

import java.util.Scanner;

/**
 *  Класс для работы с пользователем.
 */
public class ConsoleInput implements Input {
    /**
     * Класс для получения консольного ввода.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводящий вопрос.
     * @param question Вопрос.
     * @return Ответ пользователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
