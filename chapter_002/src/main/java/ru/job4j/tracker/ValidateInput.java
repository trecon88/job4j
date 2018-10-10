package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data.");
            }
        } while (invalid);
        return result;
    }
}
