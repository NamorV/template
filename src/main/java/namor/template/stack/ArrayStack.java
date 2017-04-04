package namor.template.stack;

import java.util.Arrays;

public class ArrayStack {

    private int top;
    private int size;
    private int[] stack;
    private static final int DEFAULT_SIZE = 10;

    public ArrayStack(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Can't create stack with size less than 1");
        }

        this.size = size;
        stack = new int[size];
    }

    public ArrayStack() {
        this.size = DEFAULT_SIZE;
        stack = new int[size];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int value) {
        if (top == stack.length) {
            increaseStackCapacity();
        }

        stack[top] = value;
        top++;
    }

    public int size() {
        return top;
    }

    public int peak () {
        checkIfMethodCanBeExecuted();

        return stack[top - 1];
    }


    public int pop() {
        checkIfMethodCanBeExecuted();

        int popValue = stack[top - 1];

        stack[top - 1] = 0;
        top--;

        return popValue;
    }


    private void increaseStackCapacity() {
        stack = Arrays.copyOf(stack, 2*stack.length);
    }

    private void checkIfMethodCanBeExecuted() {
        if (isEmpty()) {
            throw new MyOwnException("Can't perform action, stack is full!");
        }
    }

}
