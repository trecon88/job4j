package ru.job4j.tracker;

import java.util.Date;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.findAllItem();
            } else if (EDIT.equals(answer)) {
                this.replaceItem();
            } else  if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByIdItem();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки : ");
        String newName = this.input.ask("Введите новое имя заявки : ");
        String newDesc = this.input.ask("Введите новое описание заявки : ");
        if (this.tracker.replace(id, new Item(newName, newDesc))) {
            System.out.println("------------ Изменена заявка с Id : " + id + " --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки : ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с Id : " + id + " удалена --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }

    /**
     * Метод реализует получение списка всех заявок в хранилище.
     */
    private void findAllItem() {
        Item[] allItems = this.tracker.findAll();
        if (allItems != null) {
            System.out.println("------------ Список всех заявок --------------");

            for (Item item : allItems) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
        } else {
            System.out.println("------------ Список заявок пуст --------------");
        }
    }

    /**
     * Метод реализует получение списка заявок по имени.
     */
    private void findByNameItem() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки : ");
        Item[] foundItems = this.tracker.findByName(name);
        if (foundItems != null) {
            System.out.println("Id \t Имя \t Дата создания \t Описание");
            for (Item item : foundItems) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
        } else {
            System.out.println("------------ Не найдено заявок с именем : " + name + " --------------");
        }
    }

    /**
     * Метод реализует получение заявки по id.
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("------------ Конец вывода --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
        System.out.println("Select:");
    }

    /**
     * Запускт программы.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}