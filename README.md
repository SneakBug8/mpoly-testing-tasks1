# Лабораторная работа №1

По предмету "Основы Тестирования", студента Наконечного Павла Александровича, группа 191-362.

Задачи решены с использованием:
```
java 11 2018-09-25
Java(TM) SE Runtime Environment 18.9 (build 11+28)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11+28, mixed mode)
```

Каждая задача выполнена в отдельном файле, реализующем консольное приложение Java (т.е. запускается с помощью вызова `javac` и `java` соответствующего класса).

### Задача 1

Пользователь вводит положительное целое число. Необходимо определить количество делителей этого числа, количество нечётных делителей числа, кол-во чётных делителей числа, и сумму каждого (из перечисленных) набора. Подписывать выводимые значения.

```java
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
```



| № | Входные данные | Ожидаемый р-т | Полученный р-т |
| --- | --- | --- | --- |
| 1 | 4 |Количество всех делителей - 3<br/>Сумма всех делителей - 7<br/>Количество чётных делителей - 2<br/>Сумма чётных делителей - 6<br/>Количество нечётных делителей - 1<br/>Сумма нечётных делителей - 1|[1, 2, 4]<br/>Количество всех делителей - 3<br/>Сумма всех делителей - 7<br/>[2, 4]<br/>Количество чётных делителей - 2<br/>Сумма чётных делителей - 6<br/>[1]<br/>Количество нечётных делителей - 1<br/>Сумма нечётных делителей - 1|
| 2 | 6 |Количество всех делителей - 4<br/>Сумма всех делителей - 12<br/>Количество чётных делителей - 2<br/>Сумма чётных делителей - 8<br/>Количество нечётных делителей - 2<br/>Сумма нечётных делителей - 4|[1, 2, 3, 6]<br/>Количество всех делителей - 4<br/>Сумма всех делителей - 12<br/>[2, 6]<br/>Количество чётных делителей - 2<br/>Сумма чётных делителей - 8<br/>[1, 3]<br/>Количество нечётных делителей - 2<br/>Сумма нечётных делителей - 4|
| 3 | 5 |Количество всех делителей - 2<br/>Сумма всех делителей - 6<br/>Количество чётных делителей - 0<br/>Сумма чётных делителей - 0<br/>Количество нечётных делителей - 2<br/>Сумма нечётных делителей - 6|[1, 5]<br/>Количество всех делителей - 2<br/>Сумма всех делителей - 6<br/>[]<br/>Количество чётных делителей - 0<br/>Сумма чётных делителей - 0<br/>[1, 5]<br/>Количество нечётных делителей - 2<br/>Сумма нечётных делителей - 6|
| 4 | 1 |Количество всех делителей - 1<br/>Сумма всех делителей - 1<br/>Количество чётных делителей - 0<br/>Сумма чётных делителей - 0<br/>Количество нечётных делителей - 1<br/>Сумма нечётных делителей - 1|[1]<br/>Количество всех делителей - 1<br/>Сумма всех делителей - 1<br/>[]<br/>Количество чётных делителей - 0<br/>Сумма чётных делителей - 0<br/>[1]<br/>Количество нечётных делителей - 1<br/>Сумма нечётных делителей - 1|
| 5 | 0 |Введено неверное значение!|Введено неверное значение!|

### Задача 2
Пользователь вводит количество домов на улице. На одной стороне улицы с чётными, на другой - с нечетными. В одном из домов живёт человек (вводит пользователь). Он же вводит номер дома, к которому этому человеку надо дойти. Время в пути от дома к дому - 1 минута. Время перехода от дома до середины улицы - 30 секунд. Сколько времени займёт путешествие этого человека?

```java
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
```



| №    | Входные данные                                               | Ожидаемый р-т             | Полученный р-т                                               |
| ---- | ------------------------------------------------------------ | ------------------------- | ------------------------------------------------------------ |
| 1    | Количество домов:<br/>6<br/>Где живёт человек<br/>1<br/>Где заканчивает человек<br/>2 | Маршрут:<br/>1.0          | Маршрут:<br/>1.0                                             |
| 2    | Количество домов:<br/>0                                      | Неверное количество домов | Exception in thread "main" java.lang.Error: Неверное количество домов<br/>        at Task2.main(Task2.java:14) |
| 3    | Количество домов:<br/>1<br/>Где живёт человек<br/>1<br/>Где заканчивает человек<br/>1 | Маршрут:<br/>0.0          | Маршрут:<br/>0.0                                             |
| 4    | Количество домов<br/>2<br/>Где живёт человек<br/>2<br/>Где заканчивает человек<br/>3 | Неверный номер дома       | Exception in thread "main" java.lang.Error: Неверный номер дома<br/>        at Task2.checkmaxhouse(Task2.java:35)<br/>        at Task2.main(Task2.java:21) |
| 5    | Количество домов:<br/>6<br/>Где живёт человек<br/>1<br/>Где заканчивает человек<br/>6 | Маршрут:<br/>3.0          | Маршрут:<br/>3.0                                             |

### Задача 3
Человек в начале улицы (между первым и вторым домами). Пользователь вводит 2 числа, с номерами домов в которые должен сходить человек. Сначала он идёт в самый дальний дом. А потом в оставшийся. Вывести время его движения.

```java
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

            double firstpath = pathfromcenter(firsthouse);
            double secondpath = pathfromcenter(secondhouse);

            if (firstpath < secondpath) {
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
```



| №    | Входящие данные | Ожидаемый р-т | Полученный р-т |
| ---- | --------------- | ------------- | -------------- |
| 1 | Количество домов:<br/>6<br/>Первый дом<br/>-1 | Неверный номер дома | Exception in thread "main" java.lang.Error: Неверный номер дома<br/>        at Task2.checkmaxhouse(Task2.java:35)<br/>        at Task3.main(Task3.java:18) |
| 2    | Количество домов:<br/>0                                      | Неверное количество домов | Exception in thread "main" java.lang.Error: Неверное количество домов<br/>        at Task2.main(Task2.java:14) |
| 3 | Количество домов:<br/>6<br/>Первый дом<br/>1<br/>Второй дом<br/>6 | Фрагмент 1:<br/>2.5<br/>Фрагмент 2<br/>3.0<br/>Итого<br/>5.5 | Фрагмент 1:<br/>2.5<br/>Фрагмент 2<br/>3.0<br/>Итого<br/>5.5 |
| 4 | Количество домов:<br/>6<br/>Первый дом<br/>6<br/>Второй дом<br/>1 | Фрагмент 1:<br/>2.5<br/>Фрагмент 2<br/>3.0<br/>Итого<br/>5.5 | Фрагмент 1:<br/>2.5<br/>Фрагмент 2<br/>3.0<br/>Итого<br/>5.5 |
| 5 | Количество домов:<br/>6<br/>Первый дом<br/>2<br/>Второй дом<br/>3 | Фрагмент 1:<br/>1.5<br/>Фрагмент 2<br/>2.0<br/>Итого<br/>3.5 | Фрагмент 1:<br/>1.5<br/>Фрагмент 2<br/>2.0<br/>Итого<br/>3.5 |

### Задача 4
Пользователь вводит неограниченное количество номеров домов. И человек идёт сначала в самый дальний. Самый дальний от него и так далее. И уходит с этой улицы (в её конец).

```java
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Task4 extends Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        print("Количество домов:");
        int housescount = scanner.nextInt();

        if (housescount <= 0) {
            throw new Error("Неверное количество домов");
        }

        print("Введите дома (закончить нулём)");
        List<Integer> houses = new ArrayList<Integer>();
        while (true) {
            int res = scanner.nextInt();

            if (res > housescount) {
                throw new Error("Неправильный номер дома");
            }

            if (res != 0) {
            houses.add(res);
            }
            else {
                break;
            }
        }

        int position = 1;
        double lane = 0.5;

        double total = 0;

        while (houses.size() > 0) {
            int target = getMaxPath(position, lane, houses);

            total += path(position, getposition(target), lane, getlane(target));

            print("Идём в дом " + target + " (путь: " + total + ")");

            position = getposition(target);
            lane = getlane(target);

            houses.remove((Object) target);
        }

        total += path(position, getposition(housescount), lane, 0.5);
        print("Идём в конец улицы (путь: " + total + ")");

        print(Double.toString(total));

        scanner.close();
        System.exit(0);
    }

    static double path(double from, double to, double fromlane, double tolane) {
        return Math.abs(to - from) + Math.abs(fromlane - tolane);
    }

    protected static double path(int from, int to) {
        return path(
                getposition(from),
                getposition(to),
                getlane(from),
                getlane(to)
            );
    }

    static int getposition(int house) {
        return realcoordinate(house);
    }

    static double getlane(int house) {
        return (house + 1) % 2;
    }

    static int getMaxPath(double from, double lane, List<Integer> houses) {
        double maxpath = 0;
        int house = 0;

        for (Integer i : houses) {
            double pathlen = path(
                from,
                getposition(i),
                lane,
                getlane(i)
            );

            if (pathlen > maxpath) {
                maxpath = pathlen;
                house = i;
            }
        }

        return house;
    }
}
```



| №    | Входные данные                                               | Ожидаемый р-т                                                | Полученный р-т                                               |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | Количество домов:<br/>6<br/>Введите дома (закончить нулём)<br/>1 3 0 | Идём в дом 3 (путь: 1.5)<br/>Идём в дом 1 (путь: 2.5)<br/>Идём в конец улицы (путь: 5.0)<br/>5.0 | Идём в дом 3 (путь: 1.5)<br/>Идём в дом 1 (путь: 2.5)<br/>Идём в конец улицы (путь: 5.0)<br/>5.0 |
| 2    | Количество домов:<br/>6<br/>Введите дома (закончить нулём)<br/>1 2 7 0 | Неправильный номер дома                                      | Exception in thread "main" java.lang.Error: Неправильный номер дома<br/>        at Task4.main(Task4.java:22) |
| 3    | Количество домов:<br/>0                                      | Неверное количество домов                                    | Exception in thread "main" java.lang.Error: Неверное количество домов<br/>        at Task4.main(Task4.java:13) |
| 4    | Количество домов:<br/>6<br/>Введите дома (закончить нулём)<br/>1 2 3 4 5 6 0 | Идём в дом 5 (путь: 2.5)<br/>Идём в дом 2 (путь: 5.5)<br/>Идём в дом 3 (путь: 7.5)<br/>Идём в дом 6 (путь: 9.5)<br/>Идём в дом 1 (путь: 12.5)<br/>Идём в дом 4 (путь: 14.5)<br/>Идём в конец улицы (путь: 16.0)<br/>16.0 | Идём в дом 5 (путь: 2.5)<br/>Идём в дом 2 (путь: 5.5)<br/>Идём в дом 3 (путь: 7.5)<br/>Идём в дом 6 (путь: 9.5)<br/>Идём в дом 1 (путь: 12.5)<br/>Идём в дом 4 (путь: 14.5)<br/>Идём в конец улицы (путь: 16.0)<br/>16.0 |
| 5    | Количество домов:<br/>в                                      | Неверное количество домов                                    | Exception in thread "main" java.util.InputMismatchException<br/>        at java.base/java.util.Scanner.throwFor(Scanner.java:939)<br/>        at java.base/java.util.Scanner.next(Scanner.java:1594)<br/>        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)<br/>        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)<br/>        at Task4.main(Task4.java:10) |

### Задача 5
Пользователь с клавиатуры вводит число элементов в массиве. Инициализация  элементов массива происходит случайным образом. Числа выбираются от -130 до 28 включительно. Пока отрицательных элементов больше половины, массив переопределяется, сохраняя положительные элементы. Посчитать сумму отрицательных чисел, сумму положительных в результирующем массиве.

```java
import java.util.Scanner;
import java.util.Random;

public class Task5 {
    static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        print("Введите количество элементов");
        int number = scanner.nextInt();

        if (number < 0) {
            throw new Error("Неправильный размер массива");
        }

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
```



| №    | Входные данные                                               | Ожидаемый р-т                                                | Полученный р-т                                               |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | Введите количество элементов<br/>5<br/>-98 -38 -115 -55 -12  | ===<br/>Генерация 1<br/>1 -83 -72 28 -77<br/>===<br/>Генерация 2<br/>1 -95 -83 28 -104<br/>===<br/>Генерация 3<br/>1 -107 -43 28 -48<br/>===<br/>Генерация 4<br/>1 18 -89 28 -78<br/>===<br/>Сумма отрицательных: -167<br/>Сумма положительных: 47 | ===<br/>Генерация 1<br/>1 -83 -72 28 -77<br/>===<br/>Генерация 2<br/>1 -95 -83 28 -104<br/>===<br/>Генерация 3<br/>1 -107 -43 28 -48<br/>===<br/>Генерация 4<br/>1 18 -89 28 -78<br/>===<br/>Сумма отрицательных: -167<br/>Сумма положительных: 47 |
| 2    | Введите количество элементов<br/>3<br/>-23 5 -76             | ===<br/>Генерация 1<br/>1 5 -4<br/>===<br/>Сумма отрицательных: -4<br/>Сумма положительных: 6 | ===<br/>Генерация 1<br/>1 5 -4<br/>===<br/>Сумма отрицательных: -4<br/>Сумма положительных: 6 |
| 3    | Введите количество элементов<br/>0                           | ===<br/>Сумма отрицательных: 0<br/>Сумма положительных: 0    | ===<br/>Сумма отрицательных: 0<br/>Сумма положительных: 0    |
| 4    | Введите количество элементов<br/>-1                          | Неверный размер массива                                      | Exception in thread "main" java.lang.Error: Неправильный размер массива<br/>        at Task5.main(Task5.java:14) |
| 5    | Введите количество элементов<br/>100<br/>-23 -116 -93 -101 -50 -51 -63 13 -93 -55 -35 -108 -30 -21 -35 -82 -76 -83 -113 27 -51 -69 -15 -68 14 -78 -92 -79 8 -52 -51 25 24 -37 -74 -63 1 -4 20 -16 -16 -37 -78 21 -98 -67 -15 -47 -59 -57 -81 -11 -57 -118 -46 -67 22 -42 17 -87 -72 -26 24 <br/>20 -116 -48 -39 -16 -79 -72 0 -113 -110 -45 -36 -33 -39 -117 -78 -121 13 -6 -6 -94 28 -117 -12 15 11 -37 -96 -75 -116 -6 <br/>-69 -53 10 -35 7 -41 | ===<br/>Генерация 1<br/>11 -85 -37 15 -60 -85 -86 13 -70 -75 -28 -39 -10 -64 -39 -60 -112 -89 -22 27 -62 -10 -63 -26 14 -56 -53 -31 8 -124 -75 25 24 -120 -119 -47 1 -81 20 -99 13 -45 -57 21 -6 -25 -119 -88 -2 -88 -75 9 -18 24 -33 -94 22 -2 17 -5 -58 4 24 20 -34 -11 <br/>-96 -6 -27 -34 -12 -89 -94 -3 -72 -100 -92 -20 -93 -19 13 -52 -3 1 28 -114 -44 15 11 -41 -61 -95 -50 -127 -86 -95 10 -46 <br/>7 -118 <br/>===<br/>Генерация 2<br/>11 -34 -55 15 -67 -125 22 13 -3 -126 -68 -97 -108 -130 -94 28 8 -75 8 27 -111 -40 12 -26 14 -111 -6 -106 8 -130 -68 25 24 -130 17 -70 1 -104 20 -110 13 -76 -31 21 -51 -109 -19 21 -92 -6 26 9 -24 24 -89 -123 22 -28 17 -55 13 4 24 20 -124 -28 11 -60 12 27 26 -40 -56 -91 -25 22 -35 -128 -24 -64 13 -120 -13 1 28 -5 13 15 11 -112 16 -79 -49 25 -15 -109 10 -103 7 -51<br/>===<br/>Генерация 3<br/>11 6 -15 15 -64 -77 22 13 -68 -8 -71 -35 -26 -105 -104 28 8 4 8 27 15 -13 12 -3 14 7 9 -26 8 23 -49 25 24 28 17 3 1 -63 20 -104 13 -128 13 21 -43 -109 -44 21 -84 -109 26 9 -10 24 -45 -26 22 11 17 -12 13 4 24 20 -92 23 11 -39 12 27 26 -13 -118 -118 -63 22 -122 -72 -87 -46 13 -58 -108 1 28 7 13 15 11 -76 16 -121 -33 25 -31 -36 10 -73 7 -77<br/>===<br/>Сумма отрицательных: -2824<br/>Сумма положительных: 853 | ===<br/>Генерация 1<br/>11 -85 -37 15 -60 -85 -86 13 -70 -75 -28 -39 -10 -64 -39 -60 -112 -89 -22 27 -62 -10 -63 -26 14 -56 -53 -31 8 -124 -75 25 24 -120 -119 -47 1 -81 20 -99 13 -45 -57 21 -6 -25 -119 -88 -2 -88 -75 9 -18 24 -33 -94 22 -2 17 -5 -58 4 24 20 -34 -11 <br/>-96 -6 -27 -34 -12 -89 -94 -3 -72 -100 -92 -20 -93 -19 13 -52 -3 1 28 -114 -44 15 11 -41 -61 -95 -50 -127 -86 -95 10 -46 <br/>7 -118 <br/>===<br/>Генерация 2<br/>11 -34 -55 15 -67 -125 22 13 -3 -126 -68 -97 -108 -130 -94 28 8 -75 8 27 -111 -40 12 -26 14 -111 -6 -106 8 -130 -68 25 24 -130 17 -70 1 -104 20 -110 13 -76 -31 21 -51 -109 -19 21 -92 -6 26 9 -24 24 -89 -123 22 -28 17 -55 13 4 24 20 -124 -28 11 -60 12 27 26 -40 -56 -91 -25 22 -35 -128 -24 -64 13 -120 -13 1 28 -5 13 15 11 -112 16 -79 -49 25 -15 -109 10 -103 7 -51<br/>===<br/>Генерация 3<br/>11 6 -15 15 -64 -77 22 13 -68 -8 -71 -35 -26 -105 -104 28 8 4 8 27 15 -13 12 -3 14 7 9 -26 8 23 -49 25 24 28 17 3 1 -63 20 -104 13 -128 13 21 -43 -109 -44 21 -84 -109 26 9 -10 24 -45 -26 22 11 17 -12 13 4 24 20 -92 23 11 -39 12 27 26 -13 -118 -118 -63 22 -122 -72 -87 -46 13 -58 -108 1 28 7 13 15 11 -76 16 -121 -33 25 -31 -36 10 -73 7 -77<br/>===<br/>Сумма отрицательных: -2824<br/>Сумма положительных: 853 |



Автор: [Наконечный Павел](http://pavelnakonechnyy.ru), 191-362