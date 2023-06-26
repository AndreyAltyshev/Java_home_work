import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//    Задание
//
//    Реализуйте структуру телефонной книги с помощью HashMap.
//    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//    их необходимо считать, как одного человека с разными телефонами.
//    Вывод должен быть отсортирован по убыванию числа телефонов.
public class HomeWork5 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        adddict(map, "Маша", "123456");
        adddict(map, "Маша", "152364");
        adddict(map, "Маша", "985135");
        adddict(map, "Петя", "784654");
        adddict(map, "Петя", "065154");
        adddict(map, "Саша", "555555");
        adddict(map, "Максим", "88005553535");
        System.out.println(map);
        sortmap(map);
    }

    public static void adddict(HashMap<String, String> dict, String name, String phone) {
        dict.merge(name, phone, (old, nEw) -> old == null ? nEw : old + " " + nEw);
    }

    public static void sortmap(HashMap<String, String> map) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(s);
        }

        Collections.sort(list, (o1, o2) ->map.get(o2).split(" ").length - map.get(o1).split(" ").length);
        list.forEach(n -> System.out.println(n + " -> " + map.get(n)));

    }

}
