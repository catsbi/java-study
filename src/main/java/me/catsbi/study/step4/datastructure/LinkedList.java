package me.catsbi.study.step4.datastructure;

import java.util.Objects;

public class LinkedList {

    public static final String ERROR_INVALID_POSITION = "유효하지 않은 position입니다.";
    private ListNode head;

    public LinkedList() {
        this(null);
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public ListNode add(int data) {
        ListNode newNode = ListNode.from(data);
        return add(newNode);
    }

    public ListNode add(ListNode newNode) {
        if (isEmpty()) {
            return add(null, newNode);
        }
        return add(head, newNode, size(head));
    }

    public ListNode add(ListNode head, ListNode nodeToAdd) {
        if (isEmpty()) {
            this.head = nodeToAdd;
            return this.head;
        }
        return add(head, nodeToAdd, size(head));
    }

    private boolean isEmpty() {
        return Objects.isNull(head);
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        isValidPosition(head, position);

        ListNode beforeNode = findByPosition(head, position - 1);
        ListNode afterNode = beforeNode.next();

        ListNode linkedNode = beforeNode.linking(nodeToAdd);
        linkedNode.linking(afterNode);
        return linkedNode;
    }

    private void isValidPosition(ListNode head, int position) {
        int size = size(head);

        if (position > size || size < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_POSITION);
        }
    }


    public int size() {
        return size(head);
    }

    public int size(ListNode head) {
        if (Objects.isNull(head)) {
            return 0;
        }

        ListNode current = head;
        int size = 1;

        while (current.hasNext()) {
            size++;
            current = current.next();
        }
        return size;
    }

    public ListNode findByPosition(int position) {
        isValidPosition(this.head, position);
        return findByPosition(this.head, position);
    }

    public ListNode findByPosition(ListNode node, int position) {
        if (position == 0) {
            return node;
        }
        return findByPosition(node.next(), --position);
    }

    public ListNode getHead() {
        return this.head;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode resultNode = findByPosition(head, positionToRemove - 1);
        ListNode nextNode = resultNode.next();

        resultNode.linking(nextNode.next());

        return nextNode;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        if (head.equals(nodeToCheck)) {
            return true;
        }
        if (!head.equals(nodeToCheck) && !head.hasNext()) {
            return false;
        }
        return contains(head.next(), nodeToCheck);
    }
}
