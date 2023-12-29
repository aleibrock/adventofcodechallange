package net.leibi.adventofcode2023.day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HandTest {

    @Test
    void isBetter() {

        Hand h1 = new Hand(new Cards("AAAKK"), 103L);
        Hand h2 = new Hand(new Cards("AAKKK"), 610L);

        assertThat(h1.isBetter(h2)).isEqualTo(1);

    }
}