package anaydis.immutable;

import org.jetbrains.annotations.NotNull;

public class Node<T> implements List<T> {

    private final T element;
    private final List<T> tail;

    //Empty list
   static final List NIL = new List() {
        @Override
        public Object head() {
            throw new IllegalStateException();
        }

        @NotNull
        @Override
        public List tail() {
            throw new IllegalStateException();
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @NotNull
        @Override
        public List reverse() {
            throw new IllegalStateException();
        }
    };

    public Node(T element, List<T> tail) {
        this.element = element;
        this.tail = tail;
    }

    @Override
    public T head() {
        return element;
    }

    @NotNull
    @Override
    public List<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() { return element == null; }

    @NotNull
    @Override
    public List<T> reverse() {
        List<T> reversed = List.nil();
        List<T> current = this;
        while(!current.isEmpty()){
            reversed = List.cons(current.head(), reversed);
            current = current.tail();
        }
        return reversed;
    }
}
