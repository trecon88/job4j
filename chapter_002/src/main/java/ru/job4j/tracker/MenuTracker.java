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
    public int[] getLentgh() {
        int length = this.actions.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(StartUI.ADD, "Add new Item."));
        this.actions.add(new ShowItems(StartUI.SHOW_ALL, "Show all items."));
        this.actions.add(new EditItem(StartUI.EDIT, "Edit item."));
        this.actions.add(new DeleteItem(StartUI.DELETE, "Delete item."));
        this.actions.add(new FindItemById(StartUI.FIND_BY_ID, "Find item by Id."));
        this.actions.add(new FindItemsByName(StartUI.FIND_BY_NAME, "Find items by name."));
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
                System.out.println(String.format("%s", action.info()));
            }
        }
    }
}
