import java.util.Scanner;
import java.util.InputMismatchException;

public class Task3 extends Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            print("Количество домов:");
            int housescount = scanner.nextInt();

            if (housescount == 0) {
                throw new Error("Неверное количество домов");
            }

            print("Первый дом");

            int firsthouse = checkmaxhouse(scanner.nextInt(), housescount);
            print("Второй дом");
            int secondhouse = checkmaxhouse(scanner.nextInt(), housescount);

            if (secondhouse > firsthouse) {
                int thouse = secondhouse;
                secondhouse = firsthouse;
                firsthouse = thouse;
            }

            print("Фрагмент 1:");

            double firstpart = pathfromcenter(firsthouse);
            print(Double.toString(firstpart));

            print("Фрагмент 2");
            double secondpart = path(firsthouse, secondhouse);
            print(Double.toString(secondpart));

            print("Итого");
            print(Double.toString(firstpart + secondpart));

        } catch (InputMismatchException e) {
            throw new Error("Введено не число");
        }

        scanner.close();
        System.exit(0);
    }

    static double pathfromcenter(int b) {
        int rb = realcoordinate(b);

        return (rb - 1) + 0.5;
    }
}