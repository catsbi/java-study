package me.catsbi.study.step4.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new LinkedList();
    }

    @DisplayName("add 테스트")
    @ParameterizedTest
    @MethodSource("provideNodes")
    void add(ListNode node1, ListNode node2, ListNode node3) {
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node1, node3, 2);
        assertAll(
                () -> assertEquals(linkedList.size(), 3),
                () -> assertEquals(linkedList.findByPosition(1), node2),
                () -> assertEquals(linkedList.findByPosition(2), node3)
        );
    }

    @DisplayName("delete 테스트")
    @ParameterizedTest
    @MethodSource("provideNodes")
    void delete(ListNode node1, ListNode node2, ListNode node3) {
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node1, node3, 2);

        linkedList.remove(linkedList.getHead(), 2);

        assertEquals(2, linkedList.size());
        assertThrows(IllegalArgumentException.class, ()-> linkedList.findByPosition(3));
    }

    @DisplayName("contains 테스트")
    @ParameterizedTest
    @MethodSource("provideNodes")
    void contains(ListNode node1, ListNode node2, ListNode node3) {
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node1, node3, 2);

        ListNode node4 = ListNode.from(10);
        assertAll(
                ()->assertTrue(linkedList.contains(node1, node1)),
                ()->assertTrue(linkedList.contains(node1, node2)),
                ()->assertTrue(linkedList.contains(node1, node3)),
                ()->assertFalse(linkedList.contains(node1, node4))
        );
    }

    private static Stream<Arguments> provideNodes() {
        return Stream.of(
                Arguments.of(ListNode.from(5), ListNode.from(6), ListNode.from(7))
        );
    }
}
