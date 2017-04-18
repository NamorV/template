package namor.template.stack;

import java.util.Arrays;

public class ArrayStack {

    private int top;
    private int size;
    private int[] storage;
    private static final int DEFAULT_SIZE = 10;

    public ArrayStack(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Can't create stack with size less than 1");
        }

        this.size = size;
        storage = new int[size];
    }

    public ArrayStack() {
        this.size = DEFAULT_SIZE;
        storage = new int[size];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int value) {
        if (top == storage.length) {
            increaseCapacity();
        }

        storage[top] = value;
        top++;
    }

    public int size() {
        return top;
    }

    public int peak () {
        validateNotEmpty();

        return storage[top - 1];
    }

    public int pop() {
        validateNotEmpty();

        int popValue = storage[top - 1];

        storage[top - 1] = 0;
        top--;

        return popValue;
    }

    private void increaseCapacity() {
        storage = Arrays.copyOf(storage, 2*storage.length);
    }

    private void validateNotEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't perform action, stack is empty!");
        }
    }

}
