package ru.job4j.tracker;

import org.junit.jupiter.api.Test;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

class ItemDescByNameTest {

    @Test
    void whenSortNameDesc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Milk"),
                new Item(4, "Bread"),
                new Item(2, "Cheese")
        );
        List<Item> expected = Arrays.asList(
                new Item(4, "Bread"),
                new Item(2, "Cheese"),
                new Item(1, "Milk")
        );
        items.sort(new ItemDescByName());
        assertThat(items.equals(expected));
    }
}