package namor.template.main;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class App {

    private int top;
    int size;
    int[] stack;

    public App(int arraySize)
    {
        size = arraySize;
        stack = new int[size];
        top = -1;
    }

    public boolean IsEmpty()
    {
        return top == -1;
    }

    public void push(int value)
    {
        stack[++top] = value;
    }

    public int stackSize()
    {
        return top+1;
    }
}
