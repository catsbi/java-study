package me.catsbi.study.step4.datastructure;

import java.util.Objects;

public class ListNode {
    private final int data;
    private ListNode link;

    public ListNode(int data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public static ListNode from(int data) {
        return new ListNode(data, null);
    }

    public ListNode linking(ListNode node) {
        link = node;
        return link;
    }

    public ListNode next() {
        return link;
    }

    public boolean hasNext() {
        return Objects.nonNull(link);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return data == listNode.data && Objects.equals(link, listNode.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, link);
    }

    public int getData() {
        return data;
    }
}
