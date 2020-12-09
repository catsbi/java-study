package me.catsbi.study.step4.datastructure;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ListNodeStack {
    public static final String ERROR_EMPTY_STACK = "Stack is Empty";
    public static final String ERROR_NO_SUCH_ELEMENT = "No such element";

    private ListNode head;

    public void push(int data) {
        if (isEmpty()) {
            this.head = ListNode.from(data);
        }
        ListNode tail = getTail(head);
        tail.linking(ListNode.from(data));
    }

    private boolean isEmpty() {
        return Objects.isNull(head);
    }

    public int pop() {
        isValidPop();
        ListNode tail = getTail(head);
        ListNode tailPrev = getTailPrev(head, tail);

        tailPrev.linking(null);
        return tail.getData();
    }

    private ListNode getTail(ListNode node) {
        if (!node.hasNext()) {
            return node;
        }
        return getTail(node.next());
    }

    private ListNode getTailPrev(ListNode node, ListNode tail) {
        if (node.next().equals(tail)) {
            return node;
        }
        isAllowProgress(node);
        return getTailPrev(node.next(), tail);
    }

    private void isAllowProgress(ListNode node) {
        if (!node.hasNext()) {
            throw new NoSuchElementException(ERROR_NO_SUCH_ELEMENT);
        }
    }

    private void isValidPop() {
        if (isEmpty()) {
            throw new NoSuchElementException(ERROR_EMPTY_STACK);
        }
    }
}
