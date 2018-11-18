package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem(final int key, final String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки : ");
        if (tracker.delete(id)) {
            System.out.println("------------ Заявка с Id : " + id + " удалена --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }
}
