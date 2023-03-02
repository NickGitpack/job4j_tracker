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

    @Test
    void numberOfVerticles() {
        Box box = new Box(8, 2);
        int amount = box.getNumberOfVertices();
        assertThat(amount).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(5)
                .isLessThan(9)
                .isEqualTo(8);
    }

    @Test
    void numberOfVerticlesSecondTest() {
        Box box = new Box(6, 2);
        int amount = box.getNumberOfVertices();
        assertThat(amount).isNotZero()
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void existTest() {
        Box box = new Box(6, 2);
        boolean check = box.isExist();
        assertThat(check).isFalse();
    }

    @Test
    void existTestSecondTest() {
        Box box = new Box(8, 2);
        boolean check = box.isExist();
        assertThat(check).isTrue();
    }

    @Test
    void getArea() {
        Box box = new Box(8, 2);
        assertThat(box.getArea()).isNotZero()
                .isPositive()
                .isGreaterThan(5)
                .isLessThan(50)
                .isEqualTo(24.0);
    }

    @Test
    void getAreaSecondTest() {
        Box box = new Box(2, 2);
        assertThat(box.getArea()).isEqualTo(0.0);
    }
}