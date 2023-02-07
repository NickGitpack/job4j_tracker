package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodIsFalse() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Petr Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        assertThat(office.add(citizen2)).isFalse();
    }
}