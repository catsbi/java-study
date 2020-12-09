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

public class StackWithListNodeTest {
    private ListNodeStack nodeStack;

    @BeforeEach
    void seup() {
        nodeStack = new ListNodeStack();
    }

    @DisplayName("pushAndPop 테스트")
    @ParameterizedTest
    @MethodSource("provideInts")
    void pushAndPop(List<Integer> ints, List<Integer> results) {
        ints.forEach(nodeStack::push);

        results.forEach(value-> assertEquals(value, nodeStack.pop()));
    }


    private static Stream<Arguments> provideInts() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5), Arrays.asList(5,4,3,2,1))
        );
    }

    @DisplayName("pop with exception 테스트")
    @Test
    void popWithException() {
        assertThrows(NoSuchElementException.class, nodeStack::pop);
    }

}
