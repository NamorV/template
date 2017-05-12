package namor.template.main;

import java.util.HashMap;
import java.util.Map;

public class MapBasedStack {

    private int top;
    private Map<Integer, Integer> storage;

    public MapBasedStack() {
        storage = new HashMap();
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public  void push(int value) {
        storage.put(top, value);
        top++;
    }

    public int peak() {
        validateStackNotEmpty();

        return storage.get(top-1);
    }

    public int size() {
        return top;
    }

    public int pop() {
        int value;

        validateStackNotEmpty();
        value = peak();
        storage.remove(top-1);
        top--;

        return value;
    }

    private void validateStackNotEmpty() {
        if(isEmpty()) {
            throw new EmptyStackException("Can't perform action, stack is empty!");
        }
    }
}
