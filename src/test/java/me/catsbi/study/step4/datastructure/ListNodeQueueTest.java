package me.catsbi.study.step4.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {
    private ListNodeQueue listQueue;

    @BeforeEach
    void setup() {
        listQueue = new ListNodeQueue();
    }

    @DisplayName("addAndPoll 테스트")
    @ParameterizedTest
    @MethodSource("provideInts")
    void addAndPoll(List<Integer> ints) {
        ints.forEach(listQueue::add);
        ints.forEach(value->{
            assertEquals(listQueue.poll(), value);
        });
    }

    private static Stream<Arguments> provideInts() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5))
        );
    }
}
