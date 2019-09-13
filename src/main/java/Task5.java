import java.util.Scanner;
import java.util.Random;

public class Task5 {
    static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        print("Введите количество элементов");
        int number = scanner.nextInt();

        array = new int[number];

        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(130 + 28 + 1) - 130;
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int generation = 0;

        while (!isFinalArray()) {
            generation++;

            print("===");
            print("Генерация " + generation);
            regenerateArray();
        }

        int negativesum = 0;
        int positivesum = 0;

        for (int i : array) {
            if (i < 0) {
                negativesum += i;
            }
            else {
                positivesum += i;
            }
        }

        print("===");
        print("Сумма отрицательных: " + negativesum);
        print("Сумма положительных: " + positivesum);

        scanner.close();
        System.exit(0);
    }

    static int[] regenerateArray() {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                array[i] = rand.nextInt(130 + 28 + 1) - 130;
            }
            System.out.print(array[i] + " ");
        }

        System.out.println();
        return array;
    }

    static boolean isFinalArray() {
        int negativecount = 0;

        for (int i : array) {
            if (i < 0) {
                negativecount++;
            }
        }

        if (negativecount > array.length / 2) {
            return false;
        }

        return true;
    }

    protected static void print(String msg) {
        System.out.println(msg);
    }
}