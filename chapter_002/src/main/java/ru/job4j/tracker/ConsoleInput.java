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
}
