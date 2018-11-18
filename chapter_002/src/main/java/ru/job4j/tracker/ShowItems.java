package ru.job4j.tracker;

public class ShowItems extends BaseAction {
    public ShowItems(final int key, final String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        if (allItems != null) {
            System.out.println("------------ Список всех заявок --------------");
            System.out.println("Id \t Имя \t Дата создания \t Описание");
            for (Item item : allItems) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
        } else {
            System.out.println("------------ Список заявок пуст --------------");
        }
    }
}
