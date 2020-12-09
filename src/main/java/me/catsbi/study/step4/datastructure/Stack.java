package me.catsbi.study.step4.datastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Stack {
    public static final String ERROR_EMPTY_STACK = "Stack is Empty";
    int[] ints = new int[]{};

    void push(int data) {
        ints = Arrays.copyOf(ints, ints.length + 1);
        ints[ints.length - 1] = data;
    }

    int pop() {
        isValidPop();

        int result = ints[ints.length - 1];
        ints = Arrays.stream(this.ints, 0, this.ints.length - 1)
                .toArray();
        return result;
    }

    private void isValidPop() {
        if (ints.length == 0) {
            throw new NoSuchElementException(ERROR_EMPTY_STACK);
        }
    }
}
