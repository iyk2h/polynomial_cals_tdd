package com.ll;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcTest {
    @Test
    @DisplayName("1 + 1 == 2")
    void t1(){
        assertThat(Calc.run("1 + 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2(){
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 - 1 == 1")
    void t3() {
        assertThat(Calc.run("2 - 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t4() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }

    @Test
    @DisplayName("10 + 20 + 30 - 20 + 20== 60")
    void t5() {
        assertThat(Calc.run("10 + 20 + 30 - 20 + 20")).isEqualTo(60);
    }
}