package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comp = c;
    }
    public T max() {
        T ret = max(comp);
        return ret;
    }
    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        int ind = 0;
        T maxnow = this.get(ind);
        for (int i = 0; i < this.size(); i++) {
            if (comp.compare(this.get(i), maxnow) > 0) {
                maxnow = this.get(i);
            }
        }
        return maxnow;
    }
}
