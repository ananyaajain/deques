package deque;
import java.util.Iterator;
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class LinkNode {
        LinkNode next;
        LinkNode prev;
        T item;

        /* @lec5slides */
        public LinkNode(T i, LinkNode p, LinkNode n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }
    }

    private int size;
    private LinkNode sentinel;

    public LinkedListDeque() {
        sentinel = new LinkNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        LinkNode node = new LinkNode(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }
    public void addLast(T item) {
        LinkNode node = new LinkNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode y = sentinel;
        while (y.next != sentinel) {
            System.out.print(sentinel.next.item);
            y = y.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next.item != null && size > 0) {
            T r = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return r;
        } else {
            T r = null;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            return r;
        }
    }

    public T removeLast() {
        if (sentinel.prev.item != null) {
            T s = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return s;
        } else {
            T s = null;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return s;
        }
    }

    public T get(int index) {
        int t = index;
        LinkNode temp = sentinel.next;
        while (t > 0 && size() != 0) {
            temp = temp.next;
            t -= 1;
        }
        return temp.item;
    }
    private T helper(int index, LinkNode x) {
        if (index == 0) {
            return x.item;
        } else {
            return helper(index - 1, x.next);
        }
    }
    public T getRecursive(int index) {
        LinkNode x = sentinel.next;
        return helper(index, x);

    }
    public boolean equals(Object o) {
        if ((o instanceof Deque) && o != null) {
            if (((Deque) o).size() == this.size()) {
                for (int i = 0; i < size(); i++) {
                    if (((Deque) o).get(i) != this.get(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new LLDIterator(this);
    }
    private class LLDIterator implements Iterator<T> {
        private int ind;
        LinkedListDeque<T> lldtemp = new LinkedListDeque<>();

        public LLDIterator(LinkedListDeque<T> lldeque) {
            ind = 0;
            lldtemp = lldeque;
        }
        public boolean hasNext() {
            if (ind < lldtemp.size) {
                return true;
            }
            return false;
        }
        public T next() {
            T ret = lldtemp.get(ind);
            ind += 1;
            return ret;
        }
    }
}

