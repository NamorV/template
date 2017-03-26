package namor.template.stack;

import java.util.Arrays;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class ArrayStack {

    private int top;
    private int size;
    private int[] stack;

    public ArrayStack(int size)
    {
        this.size = size;
        stack = new int[size];
    }

    public ArrayStack()
    {
        this.size = 10;
        stack = new int[size];
    }

    public boolean IsEmpty()
    {
        return top == 0;
    }

    public void push(int value)
    {
        if (top == stack.length) {
            extendStack();
        }
        stack[top] = value;
        top++;
    }

    public int stackSize()
    {
        return top;
    }

    public int peak()
    {
        if(IsEmpty()) {
            throw new IllegalAccessError("Can't peak value, stack is empty!");
        }
        else {
            return stack[top-1];
        }
    }

    public int pop()
    {
        if(IsEmpty()) {
            throw new IllegalAccessError("Can't pop value, stack is empty!");
        }
        else {
            int popValue = stack[top-1];
            stack[top-1] = 0;
            top--;
            return popValue;
        }
    }

    private void extendStack()
    {
        stack = Arrays.copyOf(stack, 2*stack.length);
    }

}
