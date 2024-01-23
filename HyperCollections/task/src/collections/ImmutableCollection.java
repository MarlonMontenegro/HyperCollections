package collections;

import java.util.Objects;

public final class ImmutableCollection<E> {

    private E[] elements;

    private ImmutableCollection(E[] elements) {
        this.elements = elements;
    }

    private ImmutableCollection() {

    }

    public static <E> ImmutableCollection<E> of() {
        return new ImmutableCollection<>(emptyArray());
    }

    @SafeVarargs
    public static <E> ImmutableCollection<E> of(E... elements) {
        for (E element : elements) {
            Objects.requireNonNull(element, "Elements in the collection must not be null");
        }

        E[] copyElements = elements.clone();

        return new ImmutableCollection<>(copyElements);
    }

    private static <E> E[] emptyArray() {
        return (E[]) new Object[0];
    }

    public boolean contains(E element) {
        if (elements == null) {
            return false;
        }

        return indexOf(element) >= 0;
    }

    private int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < elements.length; i++) {
                if (Objects.equals(null, elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }
}