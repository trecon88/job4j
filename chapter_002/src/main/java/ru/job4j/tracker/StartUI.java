package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    protected static final int ADD = 0;
    /**
     * Константа меню для отображения всех заявок.
     */
    protected static final int SHOW_ALL = 1;
    /**
     * Константа меню для редактирования заявки.
     */
    protected static final int EDIT = 2;
    /**
     * Константа меню для удаления заявки.
     */
    protected static final int DELETE = 3;
    /**
     * Константа меню для поиска заявки по ID.
     */
    protected static final int FIND_BY_ID = 4;
    /**
     * Константа меню для поиска заявки по имени.
     */
    protected static final int FIND_BY_NAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    protected static final int EXIT = 6;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select: ", menu.getLentgh()));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}