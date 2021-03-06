package ru.job4j.tracker;

public class FindItemById extends BaseAction {
    public FindItemById(final int key, final String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите ID заявки : ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Id \t Имя \t Дата создания \t Описание");
            System.out.println(item);
            System.out.println("------------ Конец вывода --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }
}
