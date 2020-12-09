package me.catsbi.study.step4.datastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue {
    public static final String ERROR_NO_SUCH_ELEMENT = "No such element";

    private int[] ints = new int[]{};

    public boolean add(int data) {
        try{
            ints = Arrays.copyOf(ints, ints.length + 1);
            ints[ints.length - 1] = data;
            return true;
        }catch(Exception error){
            System.out.println(error.getMessage());
            return false;
        }
    }

    public int poll() {
        isValid();

        int result = peek();
        ints = Arrays.stream(this.ints, 1, this.ints.length).toArray();

        return result;
    }

    public int peek() {
        isValid();
        return ints[0];
    }

    private void isValid() {
        if(isEmpty()){
            throw new NoSuchElementException(ERROR_NO_SUCH_ELEMENT);
        }
    }

    public boolean isEmpty() {
        return ints.length == 0;
    }
}
