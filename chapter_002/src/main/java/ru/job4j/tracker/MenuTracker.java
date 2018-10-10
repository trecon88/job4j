package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     *  хранит ссылку на объект .
     */
    private Input input;
    /**
     *  хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     *  хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
       // this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                //action.info()
                System.out.println(String.format("%s. %s", action.key(), action.info()));
            }
        }
    }
}
