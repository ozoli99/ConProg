import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> implements Stack<T> {

    private final List<T> elements = new ArrayList<>();

    public static <T> Stack<T> synchronizedStack(Stack<T> stack) {
        return new Stack<T>() {
            @Override
            public synchronized void push(T element) { stack.push(element); }

            @Override
            public boolean isEmpty() { return stack.isEmpty(); }

            @Override
            public synchronized T pop() { return stack.pop(); }

            @Override
            public T top() { return stack.top(); }
        };
    }

    @Override
    public void push(T element) {
        elements.add(element);
    }

    @Override
    public boolean isEmpty() { return elements.isEmpty(); }

    @Override
    public T pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("element cannot be popped from an empty stack");
        }
        T top = top();
        elements.remove(elements.size() - 1);
        return top;
    }

    @Override
    public T top() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("there is no top element on an empty stack");
        }
        return elements.get(elements.size() - 1);
    }
}
