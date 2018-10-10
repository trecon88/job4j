package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return StartUI.DELETE;
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

    @Override
    public String info() {
        return "Delete item.";
    }
}
