package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int first;
    private int last;
    private int size;
    private T[] arr;
    private static final int START = 8;
    private static final int OKAYSIZE = 16;

    public ArrayDeque() {
        size = 0;
        first = -1;
        last = -1;
        arr = (T[]) new Object[START];
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int count = 0;
        if (last != -1) {
            for (int i = 0; i <= last; i++) {
                a[i] = arr[i];
            }
        }
        if (first != -1) {
            for (int i = 0; i < arr.length - first; i++) {
                a[capacity - i - 1] = arr[arr.length - i - 1];
                count += 1;
            }
            first = a.length - count;
        }
        arr = a;
    }
    private boolean isFull() {
        if (size == arr.length) {
            return true;
        }
        return false;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize(arr.length * 2);
        }
        if (isEmpty()) {
            first = -1;
            last = -1;
        }
        if (first == -1 || first == 0) {
            first = arr.length - 1;
            arr[first] = item;
            size += 1;
        } else {
            first -= 1;
            arr[first] = item;
            size += 1;
        }
    }

    public void addLast(T item) {
        if (isFull()) {
            resize(arr.length * 2);
        }
        if (last == arr.length - 1) {
            if (arr[last] == null) {
                arr[last] = item;
                size += 1;
            } else {
                last = 0;
                arr[last] = item;
                size += 1;
            }
        } else if (last == 0) {
            last += 1;
            arr[last] = item;
            size += 1;
        } else {
            last += 1;
            arr[last] = item;
            size += 1;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (arr.length > OKAYSIZE) {
            if ((size / arr.length) >= 0.25) {
                resize(arr.length / 2);
            }
        }
        if (first == -1) {
            if (size == 0) {
                last = -1;
            }
            if (arr[0] != null && size == 1) {
                T x = arr[0];
                arr[0] = null;
                last = -1;
                size -= 1;
                return x;
            }
            if (arr[0] != null && size >= 1) {
                T x = arr[0];
                arr[0] = null;
                //last = -1;
                size -= 1;
                return x;
            }
            if (arr[0] == null && size >= 1) {
                T x = arr[1];
                arr[1] = null;
                last = -1;
                size -= 1;
                return x;
            }
            return null;
        } else if (first == arr.length - 1) {
            T x = arr[first];
            arr[first] = null;
            size -= 1;
            first = 0;
            return x;
        } else if (first == 0) {
            T x = arr[first];
            arr[first] = null;
            first += 1;
            size -= 1;
            return x;
        } else {
            T x = arr[first];
            arr[first] = null;
            first += 1;
            size -= 1;
            return x;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (arr.length > OKAYSIZE) {
            if ((size / arr.length) >= 0.25) {
                resize(arr.length / 2);
            }
            return null;
        }
        if (last == -1) {
            if (arr[first] != null) {
                last = arr.length - 1;
                T x = arr[last];
                arr[last] = null;
                size -= 1;
                return x;
            } else {
                return null;
            }
        } else if (last == 0) {
            T x = arr[0];
            arr[0] = null;
            last = -1;
            size -= 1;
            return x;
        } else if (last == arr.length - 1) {
            if (arr[last] == null) {
                if (arr[first] != null) {
                    last -= 1;
                    T x = arr[last];
                    arr[last] = null;
                    size -= 1;
                    return x;
                } else {
                    return null;
                }
            } else {
                T x = arr[last];
                arr[last] = null;
                last -= 1;
                size -= 1;
                return x;
            }
        } else {
            T x = arr[last];
            arr[last] = null;
            last -= 1;
            size -= 1;
            return x;
        }
    }

    public T get(int index) {
        if (size == 0 || index > (arr.length - 1)) {
            return null;
        } else if (first == -1) {
            return arr[index];
        } else {
            return arr[(first + index) % arr.length];
        }
    }
    public boolean equals(Object o) {
        if (o instanceof deque.ArrayDeque arr1) {
            return this.size == arr1.size;
        } else {
            return false;
        }
    }

    public Iterator<T> iterator() {
        return new ADIterator(this);
    }

    private class ADIterator implements Iterator<T> {
        private int ind;
        ArrayDeque<T> arrd = new ArrayDeque<>();

        public ADIterator(deque.ArrayDeque<T> array) {
            ind = 0;
            arrd = array;
        }
        @Override
        public boolean hasNext() {
            if (ind < arrd.size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T ret = arrd.get(ind);
            ind += 1;
            return ret;
        }
    }
}

