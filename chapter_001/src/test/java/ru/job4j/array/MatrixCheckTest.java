package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueOddThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataMonoByTrueAndFalseEvenThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, false, true},
                {true, false, true, true},
                {false, true, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueOddThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataNotMonoByTrueEvenThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, false, true},
                {true, false, false, true},
                {false, true, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

}