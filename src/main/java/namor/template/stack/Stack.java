package namor.template.stack;

public interface Stack<T> {
    boolean isEmpty();
    void push(T value);
    int size();
    T peak ();
    T pop();
}
