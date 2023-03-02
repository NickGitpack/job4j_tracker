package ru.job4j.designe.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).isNotEmpty()
                .hasSize(5)
                .contains("first")
                .containsOnly("first", "second", "three", "four", "five")
                .startsWith("first")
                .endsWith("five");
    }

    @Test
    void checkSet() {
        SimpleConvert sc = new SimpleConvert();
        Set<String> set = sc.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .hasSize(5)
                .contains("first")
                .containsOnly("first", "second", "three", "four", "five");
    }

    @Test
    void checkMap() {
        SimpleConvert sc = new SimpleConvert();
        Map<String, Integer> map = sc.toMap("zero", "first", "second", "three", "four", "five");
        assertThat(map).hasSize(6)
                .containsKeys("zero", "first", "second", "three", "four", "five")
                .containsValues(0, 1, 2, 3, 4, 5)
                .doesNotContainKey("seven")
                .doesNotContainValue(7)
                .containsEntry("first", 1);
    }
}