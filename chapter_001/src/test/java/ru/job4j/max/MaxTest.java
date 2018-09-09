package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenFirstLessSecontThenSecond() {
        Max maximum = new Max();

        int result = maximum.max(2, 4);
        int expected = 4;

        assertThat(result, is(expected));
    }

}