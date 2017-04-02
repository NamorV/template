package namor.template.stack;

import java.util.Arrays;

public class ArrayStack {

    private int top;
    private int size;
    private int[] stack;
    private static final int SIZE = 10;

    public ArrayStack(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Can't create stack with size less than 1");
        }

        this.size = size;
        stack = new int[size];
    }

    public ArrayStack() {
        this.size = SIZE;
        stack = new int[size];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int value) {
        if (top == stack.length) {
            extendStack();
        }

        stack[top] = value;
        top++;
    }

    public int stackSize() {
        return top;
    }

    public int peak () {
        illegalAction("Can't peak value, stack is empty!");

        return stack[top - 1];
    }


    public int pop() {
        illegalAction("Can't peak value, stack is empty!");

        int popValue = stack[top - 1];

        stack[top - 1] = 0;
        top--;

        return popValue;
    }


    private void extendStack() {
        stack = Arrays.copyOf(stack, 2*stack.length);
    }

    private void illegalAction(String msg) {
        if (isEmpty()) {
            throw new RuntimeException(msg);
        }
    }

}
