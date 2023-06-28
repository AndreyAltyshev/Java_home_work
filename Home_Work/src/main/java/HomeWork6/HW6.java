package HomeWork6;

import java.util.HashMap;
import java.util.Iterator;

public class HW6 {
    public static void main(String[] args) {
        Set<Integer> set1 = new Set();
        set1.add(555);
        set1.add(123);
        set1.add(124);
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());
        };
        System.out.println(set1.toString());
        System.out.println(set1.toIndex(1));
    }
}



