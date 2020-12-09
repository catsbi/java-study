package me.catsbi.study.step4.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack();
    }

    @DisplayName("pushAndPop테스트")
    @ParameterizedTest
    @MethodSource("provideStackDataStructure")
    void pushAndPop(List<Integer> ints, List<Integer> popValues) {
        ints.forEach(stack::push);

        popValues.forEach(value-> assertEquals(value, stack.pop()));
    }

    private static Stream<Arguments> provideStackDataStructure() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5), Arrays.asList(5,4,3,2,1))
        );
    }

    @DisplayName("pop exception test")
    @Test
    void popWithException() {
        assertThrows(NoSuchElementException.class, stack::pop);
    }

}
