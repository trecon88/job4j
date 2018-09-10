package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenFirstLessSecondThenSecond() {
        Max maximum = new Max();

        int result = maximum.max(2, 4);
        int expected = 4;

        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondMaxOfThreeThenSecond() {
        Max maximum = new Max();

        int result = maximum.max(2, 8, 3);
        int expected = 8;

        assertThat(result, is(expected));
    }

}