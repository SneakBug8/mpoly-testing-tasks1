import java.util.Scanner;
import java.util.InputMismatchException;

public class Task2 extends Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            print("Количество домов:");
            int housescount = scanner.nextInt();

            if (housescount <= 0) {
                throw new Error("Неверное количество домов");
            }

            print("Где живёт человек");
            int startinghouse = checkmaxhouse(scanner.nextInt(), housescount);

            print("Где заканчивает человек");
            int endhouse = checkmaxhouse(scanner.nextInt(), housescount);

            print("Маршрут: ");
            print(Double.toString(path(startinghouse, endhouse)));
        } catch (InputMismatchException e) {
            throw new Error("Введено не число");
        }

        scanner.close();
        System.exit(0);
    }

    protected static int checkmaxhouse(int a, int max) {
        if (a > max || a < 1) {
            throw new Error("Неверный номер дома");
        }

        return a;
    }

    protected static double path(int a, int b) {
        int ra = realcoordinate(a);
        int rb = realcoordinate(b);

        return Math.abs((ra - rb)) + Math.abs(a - b) % 2;
    }

    protected static int realcoordinate(int housenumber) {
        return (int) (housenumber + housenumber % 2) / 2;
    }
}