import by.gsu.training.final2.*;

public class Runner2 {
    public static void main(String[] args) {
        // 1. Создать пассажирский поезд.
        showTitle("Задание №1");
        PassengerTrain train = new PassengerTrain("808A",
                new Locomotive(1975, TypeLocomotive.DIESEL_LOCOMOTIVE, 20),
                new Carriage[]{
                        new EconomCarriage(1974, 1, 32, 16,
                                "Katya", "Petya"),
                        new SeatsCarriage(1666, 2, 100, 53, TypeSeats.HARD),
                        new SeatsCarriage(2022, 3, 80, 79, TypeSeats.SOFT),
                        new CompartmentCarriage(2016, 4, 40, 32, 32,
                                "Vasya"),
                        new EconomCarriage(2002, 5, 36, 18,
                                "Barbara", "Evgeniy"),
                        new CompartmentCarriage(4321, 99, 30, 0, 24,
                                "Count Saint Germain The Mysterious")
                });
        train.show();

        // 2. Подсчитать общую численность пассажиров поезда.
        showTitle("Задание №2");
        int passengers = countPassengers(train);
        System.out.println("Всего пассажиров: " + passengers);

        // 3. Узнать общее количество свободных мест во всех вагонах заданного типа.
        showTitle("Задание №3");
        int freeSeatsAtCompartment = train.getFreeSeats(TypeRollingStock.COMPARTMENT);
        System.out.println("Всего свободных мест в купэйных вагонах: " + freeSeatsAtCompartment);

        // 4. Узнать количество свободных мест в вагоне с заданным номером.
        showTitle("Задание №4");
        int number = 2;
        Carriage carriage = train.getCarriageByNumber(number);
        if (carriage != null) {
            int freeSeatsInSecondCarriage = carriage.getSEATS() - carriage.getPassengers();
            System.out.println("Свобоных мест в вагоне #" + number + ": " + freeSeatsInSecondCarriage);
        } else {
            System.out.println("Тут нет вагона #" + number);
        }

        // 5. Посадить в поезд заданное количество пассажиров в вагоны с мягкими местами для сидения.
        // (если всех посадить не удалось, вывести на экран количество пассажиров, которых не удалось посадить в поезд).
        showTitle("Задание №5");
        int trainlessPassengers = putGuysIntoTrain(train, 123, ComfortLevel.SOFT_SEAT);
        System.out.println("Мы посадили в поезд пассажиров!");
        if (trainlessPassengers > 0) {
            System.out.println("ERROR! Passengers without seats: " + trainlessPassengers);
        }
        train.show();

        // 6. Высадить из каждого купейного вагона по 5 пассажиров (если в вагоне меньше пассажиров, высадить всех).
        showTitle("Задание №6");
        takeOffPassengersFromTrain(train, 5, TypeRollingStock.COMPARTMENT);
        System.out.println("Мы высадили из купейных вагонов по 5 пассажиров!");
        train.show();

        // 7. Вывести в консоль информацию о вагонах с количеством пассажиров из заданного диапазона.
        showTitle("Задание №7");
        System.out.println("Вагоны, в которых не больше 32 пссажиров: ");
        showCarriagesInRange(train, 0, 32);

        // 8. Узнать, сможет ли поезд проехать заданное расстояние (в километрах) за заданное время (в минутах),
        // если будет ехать с максимально возможной для локомотива скоростью.
        showTitle("Задание №8");
        int minutes = 123;
        double maxTravelDistance = train.getLocomotive().getMaxSpeed()  * minutes / 60.;
        System.out.println("За " + minutes + " минут поезд может проехать " + maxTravelDistance + "км.");

        // 9. Если у поезда локомотив-тепловоз, заменить его на локомотив-электровоз.
        showTitle("Задание №9");
        Locomotive locomotive = train.getLocomotive();
        if (locomotive.getLocomotiveType() == TypeLocomotive.DIESEL_LOCOMOTIVE) {
            train.setLocomotive(new Locomotive(4321, TypeLocomotive.ELECTRIC_LOCOMOTIVE, 123));
            System.out.println("Мы поставили локомотив-электровоз: " + train.getLocomotive());
        } else {
            System.out.println("Тут уже локомотив-электровоз: " + train.getLocomotive());
        }

        // 10. Отсортировать вагоны поезда по убыванию уровня комфортности.
        showTitle("Задание №10");
        train.sortByComfortLevel();
        System.out.println("Вагоны отсортированы по убыванию их комфортности");
        train.show();

        // 11. Вывести информацию о всех проводниках поезда в консоль.
        showTitle("Задание №11");
        train.showConductors();

        // 12. Подсчитать общее количество подвижного состава в поезде (локомотив и вагоны),
        // год выпуска которых раньше заданного.
        showTitle("Задание №12");
        int oldCarriages = countOldCarriages(train, 1999);
        System.out.println("В поезде присутствуют " + oldCarriages + " вагонов, родившихся до " + 2000);
    }

    public static int countPassengers(PassengerTrain train) {
        int passengers = 0;
        int carriages = train.getNumberOfCarriages();
        for (int i = 0; i < carriages; i++) {
            passengers += train.getCarriageByIndex(i).getPassengers();
        }
        return passengers;
    }

    public static int putGuysIntoTrain(PassengerTrain train, int guys, ComfortLevel comfort) {
        int carriages = train.getNumberOfCarriages();
        for (int i = 0; i < carriages; i++) {
            Carriage carriage = train.getCarriageByIndex(i);
            if (carriage.getComfortLevel() == comfort) {
                int deltaGuys = Math.min(carriage.getSEATS() - carriage.getPassengers(), guys);
                carriage.setPassengers(carriage.getPassengers() + deltaGuys);
                guys -= deltaGuys;
            }
        }
        return guys;
    }

    public static void takeOffPassengersFromTrain(PassengerTrain train, int guys, TypeRollingStock type) {
        int carriages = train.getNumberOfCarriages();
        for (int i = 0; i < carriages; i++) {
            Carriage carriage = train.getCarriageByIndex(i);
            if (carriage.getType() == type) {
                carriage.setPassengers(Math.max(0, carriage.getPassengers() - guys));
            }
        }
    }

    public static void showCarriagesInRange(PassengerTrain train, int minPassengers, int maxPassengers) {
        int carriages = train.getNumberOfCarriages();
        for (int i = 0; i < carriages; i++) {
            Carriage carriage = train.getCarriageByIndex(i);
            int passengers = carriage.getPassengers();
            if (passengers >= minPassengers && passengers <= maxPassengers) {
                carriage.show();
            }
        }
    }

    public static int countOldCarriages(PassengerTrain train, int maxYearOfBirth) {
        int counter = 0;
        if (train.getLocomotive().getYEAR_OF_BIRTH() <= maxYearOfBirth) {
            counter = 1;
        }
        int carriages = train.getNumberOfCarriages();
        for (int i = 0; i < carriages; i++) {
            Carriage carriage = train.getCarriageByIndex(i);
            if (carriage.getYEAR_OF_BIRTH() <= maxYearOfBirth) {
                counter += 1;
            }
        }
        return counter;
    }

    public static void showTitle(String message) {
        System.out.println("------- " + message + " -------");
    }
}
