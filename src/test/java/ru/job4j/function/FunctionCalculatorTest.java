package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenSqFunctionThenSqResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> x * x + 1);
        List<Double> expected = Arrays.asList(5D, 10D, 17D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadFunctionThenQuadResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(5D, 28D, 257D);
        assertThat(result).containsAll(expected);
    }
}