package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueEvenThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataMonoByFalseOddThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueEvenThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataNotMonoByTrueOddThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}