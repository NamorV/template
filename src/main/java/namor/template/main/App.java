package namor.template.main;

import java.util.Arrays;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class App {

    private int top;
    int size;
    int[] stack;

    public App(int arraySize)
    {
        size = arraySize;
        stack = new int[size];
        top = 0;
    }

    public boolean IsEmpty()
    {
        return top == 0;
    }

    public void push(int value)
    {
        if (top == stack.length)
        {
            extendStack();
        }
        stack[top] = value;
        top++;
    }

    public int stackSize()
    {
        return top;
    }

    public void pop()
    {
        if(!IsEmpty())
        {
            stack[top-1] = 0;
            top--;
        }

    }

    public int peak()
    {
        if (!IsEmpty())
        {
            return stack[top-1];
        }
        else return -1;
    }


    private void extendStack()
    {
        stack = Arrays.copyOf(stack, stack.length+1);
    }

}
