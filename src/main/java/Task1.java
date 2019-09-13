import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Task1 {
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        int number;

        print("Введите число");

        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            throw new Error("Введено не число");
        }

        List<Integer> vse = new ArrayList<Integer>();
        List<Integer> chetn = new ArrayList<Integer>();
        List<Integer> nechetn = new ArrayList<Integer>();


        if (number <= 0) {
            System.out.println("Введено неверное значение!");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                vse.add(i);
                if (i % 2 == 0) {
                    chetn.add(i);
                }
                else {
                    nechetn.add(i);
                }
            }
        }

        print(vse.toString());

        print("Количество всех делителей - " + vse.size() + "\n" +
                "Сумма всех делителей - " + sum(vse));

        print(chetn.toString());

        print("Количество чётных делителей - " + chetn.size() + "\n" +
                "Сумма чётных делителей - " + sum(chetn));

        print(nechetn.toString());

        print("Количество нечётных делителей - " + nechetn.size() + "\n" +
                "Сумма нечётных делителей - " + sum(nechetn));

        scanner.close();
        System.exit(0);
    }

    protected static int sum(List<Integer> array) {
        int res = 0;
        for (int i : array) {
            res += i;
        }
        return res;
    }

    protected static void print(String msg) {
        System.out.println(msg);
    }
}