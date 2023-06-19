import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HomeWork3 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = 100;
        generator(list, len, 250);

        System.out.println("Произвольный список из 100 эл-в: ");
        printlist(list);
        remover_even(list);
        System.out.println("Список после удаления чётных чисел: ");
        printlist(list);
        System.out.println("Минимальное значение в результирующем списке => " + Collections.min(list));
        System.out.println("Максимальное значение в результирующем списке => " + Collections.max(list));
        System.out.format("Среднее арифметическое списка => %.2f", arith_mean(list));

    }

    static void generator(ArrayList<Integer> lst, int len, int max) {
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            lst.add(rand.nextInt(0, max));
        }
    }

    static void remover_even(ArrayList<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; --i) {
            if (lst.get(i) % 2 == 0) lst.remove(i);
        }
    }

    static void printlist(ArrayList<Integer> lst) {
        for (int i : lst) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    static float arith_mean(ArrayList<Integer> lst) {
        float count = 0;
        for (int i : lst) {
            count += i;
        }
        return count / lst.size();

    }
}
