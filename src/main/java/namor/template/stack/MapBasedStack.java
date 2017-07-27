package namor.template.stack;

import java.util.HashMap;
import java.util.Map;

public class MapBasedStack<T> {

    private int top;
    private Map<Integer, T> storage;

    public MapBasedStack() {
        storage = new HashMap<Integer, T>();
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public  void push(T value) {
        storage.put(top, value);
        top++;
    }

    public T peak() {
        validateStackNotEmpty();

        return storage.get(top-1);
    }

    public int size() {
        return top;
    }

    public T pop() {
        T value;

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
