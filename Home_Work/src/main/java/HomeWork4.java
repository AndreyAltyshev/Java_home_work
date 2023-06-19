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

        input_data(surname, name, patronymic, age, gender, keys);
        print_data(surname, name, patronymic, age, gender, keys);

        System.out.println("Выберимте действие: q - выход, s - отсортировать по возрасту");
        String data = scaner.nextLine();
        if (data.equals("q")) System.exit(0);
        System.out.println("Сортировка по возрасту");
        System.out.println("__________________");
        sortdata_age();
        System.out.println("Сортировка по возрасту и полу");
        System.out.println("__________________");
        sortdata_age_and_gender();


    }

    static void input_data(ArrayList<String> surname, ArrayList<String> name,
                           ArrayList<String> patronymic, ArrayList<Integer> age,
                           ArrayList<String> gender, ArrayList<Integer> keys) {

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

    static void print_data(ArrayList<String> surname, ArrayList<String> name,
                           ArrayList<String> patronymic, ArrayList<Integer> age,
                           ArrayList<String> gender, ArrayList<Integer> keys) {
        for (Integer i : keys) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0)
                    + " " + patronymic.get(i).toUpperCase().charAt(0) + " " + age.get(i) + " " + gender.get(i));
        }
    }

    static void sortdata_age() {
        ArrayList<Integer> temp_keys = new ArrayList<>();
        ArrayList<Integer> tmp_age = new ArrayList<>();
        tmp_age.addAll(age);
        for (int i = 0; i < age.size(); i++) {
            temp_keys.add(age.indexOf(Collections.min(tmp_age)));
            tmp_age.remove(tmp_age.indexOf(Collections.min(tmp_age)));
        }
        print_data(surname, name, patronymic, age, gender, temp_keys);
    }

    static void sortdata_age_and_gender() {
        ArrayList<Integer> temp_keys = new ArrayList<>();
        ArrayList<Integer> tmp_age = new ArrayList<>();
        tmp_age.addAll(age);
        for (int i = 0; i < age.size(); i++) {
            temp_keys.add(age.indexOf(Collections.min(tmp_age)));
            tmp_age.remove(tmp_age.indexOf(Collections.min(tmp_age)));
        }
        int tmp;
        int k = 0;
        ArrayList<Integer> temp_keys1 = new ArrayList<>();
        temp_keys1.addAll(temp_keys);
        for (int i = 0; i < keys.size()-1; i++) {
            if (gender.get(temp_keys.get(i)).toLowerCase().equals("ж")) {
                tmp = temp_keys1.get(k);
                temp_keys1.remove(k);
                temp_keys1.add(tmp);
            } else k += 1;

        }

        print_data(surname, name, patronymic, age, gender, temp_keys1);
    }


}


