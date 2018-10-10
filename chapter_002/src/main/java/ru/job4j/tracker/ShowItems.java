package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public int key() {
        return StartUI.SHOW_ALL;
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

    @Override
    public String info() {
        return "Show all items.";
    }

}
