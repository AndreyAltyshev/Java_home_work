import java.util.Random;

public class HomeWork1 {
    public static void main(String[] args) {
        int i = rand(2000);
        int n = number_high_byte(i);
        int[] m1 =create_arr_m1(i,n);
        int [] m2 = create_arr_m2(i, n);


    }

    public static int rand(int num) {               //метод возвращающий случайное рандомное число в диапазоне от 0 до num
        Random random = new Random();
        int number = random.nextInt(num);
        return number;
    }

    public static int number_high_byte(int num) {       //метод возвращающий номер старшего бита чмсла num
        int n = Integer.toBinaryString(num).length() - 1;
        return n;
    }

    public static int[] create_arr_m1(int num, int n) {       //метод возвращающий заполненый массив кратными n значениями от num до Short.MAX_VALUE
        int[] m1 = new int[1];                              //инициализация массива длины 1
        for (int i = num; i < num + n; i++) {               // находим первое значение и записываем его в массив
            if (i % n == 0) {
                m1[0] = i;
                break;
            }
        }

        for (int i = m1[0]+n; i < Short.MAX_VALUE; i += n) {        // заполняем массив
            int[] tmp = new int[m1.length + 1];
            for (int j = 0; j < m1.length; j++) tmp[j] = m1[j];
            m1 = tmp;
            m1[tmp.length -1] = i;
        }
        return m1;
    }

    public static int[] create_arr_m2(int num, int n){              //метод возвращающий массив m2  заполненный не кратными n
                                                                    // значениями в диаппазоне от Short.MIN_VALUE до num
        int[] m2 = new int[1];
        for (int i = Short.MIN_VALUE ; i <  Short.MIN_VALUE + n; i++) {
            if (i % n != 0) {
                m2[0] = i;
                break;
            }
        }

        for (int i = m2[0]+1; i < num; i ++) {
            if(i%n != 0) {
                int[] tmp = new int[m2.length + 1];
                for (int j = 0; j < m2.length; j++) tmp[j] = m2[j];
                m2 = tmp;
                m2[tmp.length - 1] = i;
            }
        }
        return m2;
    }
}
