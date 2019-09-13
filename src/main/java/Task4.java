import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Task4 extends Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        print("Количество домов:");
        int housescount = scanner.nextInt();

        if (housescount == 0) {
            throw new Error("Неверное количество домов");
        }

        print("Введите дома (закончить нулём)");
        List<Integer> houses = new ArrayList<Integer>();
        while (true) {
            int res = scanner.nextInt();

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