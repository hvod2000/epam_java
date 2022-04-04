import by.gsu.training.final1.Trip;

import java.util.Arrays;
import java.util.HashSet;

public class Runner {
    public static void main(String[] args) {
        Trip trips[] = new Trip[] {
                new Trip("Ivan Ivanov", 1234, 567, 8),
                new Trip("Vasily Vasiliev", 500, 500, 10),
                null,
                new Trip("Peter Petrovich", 32),
                new Trip("Zhenya", 4321, 1234, 5),
                new Trip("Vasily Vasiliev", 31),
                new Trip("Vasily Vasiliev", 2100, 100000, 2),
                new Trip("Σξτ"),
                null,
                new Trip("Σξτ", 12),
                new Trip()
        };

        // Вывести содержимое массива на консоль с помощью метода show().
        printArrayOfTrips(trips);

        // Изменить транспортные расходы сотрудника из последнего объекта массива.
        trips[trips.length - 1].setTransportationExpenses(12340);

        // Добавить 1 день к последней командировке каждого сотрудника.
        System.out.println("Перед удлиением: " + Arrays.toString(trips));
        extendLastTrips(trips);
        System.out.println("После удлинения: " + Arrays.toString(trips));

        // Вывести содержимое массива на консоль (по одному элементу в строке), неявно используя метод toString().
        for (Trip trip: trips) {
            System.out.println(trip);
        }

        // Вывести суммарную продолжительность двух первых командировок сотрудника с заданным аккаунтом.
        String account =  "Vasily Vasiliev";
        int duration = durationOfFirstTwoTrips(trips, account);
        System.out.println("Продолжительность(" + account + ") = " + duration);

        // Рассчитать среднее значение командировочных расходов всех сотрудников.
        double average = averageExpenses(trips);
        System.out.println("Средние расходы на поездку: " + average);
    }


    public static void printArrayOfTrips(Trip trips[]) {
        for (int i = 0; i < trips.length; i++) {
            System.out.println("--- ПОЕЗДКА №" + (i + 1) + " ---");
            if (trips[i] != null) {
                trips[i].show();
            } else {
                System.out.println("NULL");
            }
        }
    }


    public static void extendLastTrips(Trip trips[]) {
        HashSet<String> accounts = new HashSet<String>();
        for (Trip trip: trips) {
            if (trip != null) {
                accounts.add(trip.getAccount());
            }
        }
        for (String account: accounts) {
            int i;
            for (i = trips.length - 1; trips[i] == null || trips[i].getAccount() != account; i--);
            trips[i].setDurationInDays(trips[i].getDurationInDays() + 1);
        }
    }

    public static int durationOfFirstTwoTrips(Trip trips[], String account) {
        int tripsCounted = 0;
        int sum = 0;
        for (Trip trip : trips) {
            if (trip != null && trip.getAccount() == account) {
                sum += trip.getDurationInDays();
                tripsCounted += 1;
                if (tripsCounted == 2) {
                    break;
                }
            }
        }
        if (tripsCounted != 2) {
            System.err.println("ERROR! Не удалось найти сумму двух первых командировок.");
            System.err.println("У сотрудника \"" + account + "\" меньше двух командировок!");
        }
        return sum;
    }

    public static double averageExpenses(Trip trips[]) {
        int sum = 0;
        int countNonNull = 0;
        for (Trip trip : trips) {
            if (trip != null) {
                countNonNull += 1;
                sum += trip.getTotal();
            }
        }
        if (countNonNull != 0) {
            return sum / countNonNull;
        } else {
            System.err.println("ERROR! Нельзя посчитать среднее значение, если нет сотрудников.");
            return 0;
        }
    }
}
