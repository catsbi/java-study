package me.catsbi.study.step4.datastructure;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ListNodeQueue {
    public static final String ERROR_NO_SUCH_ELEMENT = "No such element";

    private ListNode head;

    public boolean add(int data) {
        try {
            return add(ListNode.from(data));
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        }
    }

    private boolean add(ListNode newNode) {
        if (isEmpty()) {
            this.head = newNode;
            return true;
        }

        ListNode beforeHead = this.head;
        this.head = newNode;

        newNode.linking(beforeHead);

        return true;
    }

    private ListNode getTail(ListNode node) {
        if (!node.hasNext()) {
            return node;
        }
        return getTail(node.next());
    }

    public int poll() {
        isValid();

        int result = peek();
        if (isEqualsHeadAndTail()) {
            this.head = null;
            return result;
        }

        ListNode tailPrev = getTailPrev(head, getTail(head));

        tailPrev.linking(null);

        return result;
    }

    private boolean isEqualsHeadAndTail() {
        return Objects.equals(getTail(head), head);
    }

    public int peek() {
        isValid();
        return getTail(head).getData();
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

    private void isValid() {
        if (isEmpty()) {
            throw new NoSuchElementException(ERROR_NO_SUCH_ELEMENT);
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(head);
    }
}
