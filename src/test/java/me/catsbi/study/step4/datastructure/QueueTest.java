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

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue();
    }

    @DisplayName("addAndPoll 테스트")
    @ParameterizedTest
    @MethodSource("provideLists")
    void addAndPoll(List<Integer> ints) {
        ints.forEach(queue::add);

        ints.forEach(value-> assertEquals(queue.poll(), value));
    }

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6))
        );
    }

    @DisplayName("poll with exception 테스트")
    @Test
    void pollWithException() {
        assertThrows(NoSuchElementException.class, queue::poll);
    }

}
