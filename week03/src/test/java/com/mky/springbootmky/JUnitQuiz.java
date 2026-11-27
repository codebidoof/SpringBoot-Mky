package com.mky.springbootmky;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {
    String name1 = "홍길동";
    String name2 = "홍길동";
    String name3 = "홍길은";

    // 1. 모든 변수가 null이 아닌지 확인
    // 2. name1과 name2가 같은지 확인
    // 3. name1과 name3이 다른지 확인
    @Test
    public void junitQuiz1() {
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    // 1. number1은 양수인지 확인
    // 2. number2는 0인지 확인
    // 3. number3은 음수인지 확인
    // 4. number1은 number2보다 큰 지 확인
    // 5. number3은 number2보다 작은지 확인
    @Test
    public void junitQuiz2() {
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;

        assertThat(number1).isPositive();
        assertThat(number2).isZero();
        assertThat(number3).isNegative();
        assertThat(number1).isGreaterThan(number2);
        assertThat(number3).isLessThan(number2);
    }
}
