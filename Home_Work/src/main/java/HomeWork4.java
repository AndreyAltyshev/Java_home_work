import java.util.*;

public class HomeWork4 {
    static Scanner scaner = new Scanner(System.in);
    public static ArrayList<String> surname = new ArrayList<>();
    public static ArrayList<String> name = new ArrayList<>();
    public static ArrayList<String> patronymic = new ArrayList<>();
    public static ArrayList<Integer> age = new ArrayList<>();
    public static ArrayList<String> gender = new ArrayList<>();
    public static ArrayList<Integer> keys = new ArrayList<>();

    public static void main(String[] args) {

        input_data();
        print_data(keys);

        System.out.println("Выберимте действие: q - выход, s - отсортировать по возрасту");
        String data = scaner.nextLine();
        if (data.equals("q")) System.exit(0);
        System.out.println("Сортировка по возрасту");
        System.out.println("__________________");
        print_data(sortdata_age());
        System.out.println("Сортировка по возрасту и полу");
        System.out.println("__________________");
        print_data(sortdata_age_and_gender());


    }

    static void input_data() {

        System.out.println("Введите Фамилию Имя ОЧество вораст и пол ");
        int count = 0;
        while (true) {
            String data = scaner.nextLine();
            if (data.equals("q")) return;
            surname.add(data.split(" ")[0]);
            name.add(data.split(" ")[1]);
            patronymic.add(data.split(" ")[2]);
            age.add(Integer.parseInt(data.split(" ")[3]));
            gender.add(data.split(" ")[4]);
            keys.add(count);
            count += 1;
        }
    }

    static void print_data(ArrayList<Integer> keys) {
        for (Integer i : keys) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0)
                    + " " + patronymic.get(i).toUpperCase().charAt(0) + " " + age.get(i) + " " + gender.get(i));
        }
    }

    static ArrayList<Integer> sortdata_age() {
        ArrayList<Integer> sorted_keys = new ArrayList<>();
        sorted_keys.addAll(keys);
        sorted_keys.sort(new Comparator<Integer>() {
                             @Override
                             public int compare(Integer o1, Integer o2) {
                                 return age.get(o1) - age.get(o2);
                             }
                         });

//        ArrayList<Integer> tmp_age = new ArrayList<>();
//        tmp_age.addAll(age);
//        for (int i = 0; i < age.size(); i++) {
//            sorted_keys.add(age.indexOf(Collections.min(tmp_age)));
//            tmp_age.remove(tmp_age
//                    .indexOf(Collections
//                            .min(tmp_age)));
//          }
        return sorted_keys;
    }

    static ArrayList<Integer> sortdata_age_and_gender() {
        ArrayList<Integer> sorted_keys = new ArrayList<>();
        sorted_keys.addAll(sortdata_age());
        int tmp;
        int k = 0;
        ArrayList<Integer> sorted_keys1 = new ArrayList<>();
        sorted_keys1.addAll(sorted_keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if (gender.get(sorted_keys.get(i)).toLowerCase().equals("ж")) {
                tmp = sorted_keys1.get(k);
                sorted_keys1.remove(k);
                sorted_keys1.add(tmp);
            } else k += 1;

        }

        return sorted_keys1;
    }


}


