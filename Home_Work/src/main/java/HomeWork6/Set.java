package HomeWork6;

import java.lang.reflect.Array;
import java.util.*;

public class Set<E> {
    private HashMap<E, Object> set = new HashMap<>();
    private static final Object VALL = new Object();

    public boolean add(E tel) {
        return set.put(tel, VALL) == null;
    }

    public boolean remove(E tel) {
        return set.remove(tel) == VALL;
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public Iterator<E> iterator() {
        return set.keySet().iterator();
    }

    @Override
    public String toString() {
        return set.keySet().toString();
    }

    public Object toIndex(int index){
        return set.keySet().toArray()[index];
    }
}