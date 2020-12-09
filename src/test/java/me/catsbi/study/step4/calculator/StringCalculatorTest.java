package me.catsbi.study.step4.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "7 - 4:3", "8 * 3:24", "8 / 2:4"}, delimiter = ':')
    @DisplayName("간단한 문자열 사칙연산 테스트")
    public void simpleCalculateTest(String input, Integer resultValue) {
        Integer result = stringCalculator.calculate(input);
        assertEquals(result, resultValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    @DisplayName("복합 문자열 사칙 연산 계산기 구현 및 테스트")
    public void compositeCalculateTest(String input, Integer resultValue) {
        Integer result = stringCalculator.calculate(input);
        assertNotNull(result);
    }

    //":입력", " :입력", "2 +3:사칙연산",
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사칙연산 예외 테스트")
    public void calculateExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class, ()-> stringCalculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "7 - 4", "8 * 3", "8 / 2"})
    @DisplayName("간단한 문자열 사칙연산 테스트")
    public void simpleCalculateTestForWait(String input) {
        int waitTime = 1000 * 2;

        assertTimeout(Duration.ofMillis(waitTime), ()->{
            Integer result = stringCalculator.calculateForWait(input, waitTime - 1000);
        });

    }

    @Test
    @DisplayName("간단한 문자열 사칙연산 테스트 및 assertAll 테스트")
    public void simpleCalculateTestAll() {
        List<String> strings = Arrays.asList("2 + 3:5", "7 - 4:3", "8 * 3:24", "8 / 2:4");

        assertAll(()-> strings.forEach(string->{
            String[] split = string.split(":");
            assertEquals(Integer.parseInt(split[1]), stringCalculator.calculate(split[0]));
        }));
    }
}
