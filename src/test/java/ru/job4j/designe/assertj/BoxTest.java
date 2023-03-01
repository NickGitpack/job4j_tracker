package ru.job4j.designe.assertj;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(1, 2);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .contains("object")
                .startsWith("Unknown")
                .isEqualTo("Unknown object");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 2);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .contains("Cube")
                .startsWith("Cube")
                .isEqualTo("Cube");
    }
}