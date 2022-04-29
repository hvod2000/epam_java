package by.gsu.training.final2;

import java.util.Arrays;
import java.util.Comparator;

public class PassengerTrain {
    private String number;
    private Locomotive locomotive;
    private Carriage[] carriages;

    public PassengerTrain(String number, Locomotive locomotive, Carriage[] carriages) {
        this.number = number;
        this.locomotive = locomotive;
        this.carriages = carriages;
    }

    public String getNumber() {
        return number;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public int getNumberOfCarriages() {
        return carriages.length;
    }

    public int getFreeSeats(TypeRollingStock type) {
        int freeSeats = 0;
        for (Carriage carriage: carriages) {
            if (carriage.getType() == type) {
                freeSeats += carriage.getSEATS() - carriage.getPassengers();
            }
        }
        return freeSeats;
    }

    public Carriage getCarriageByNumber(int number) {
        for (Carriage carriage: carriages) {
            if (carriage.getNumber() == number) {
                return carriage;
            }
        }
        return null;
    }

    public Carriage getCarriageByIndex(int index) {
        if (index >= 0 && index < carriages.length) {
            return carriages[index];
        }
        return null;
    }

    public void show() {
        System.out.println("Train #" + number);
        System.out.println("Locomotive: " + locomotive);
        for (Carriage carriage : carriages) {
            carriage.show();
        }
    }

    public void showConductors() {
        for (Carriage carriage : carriages) {
            System.out.print("Carriage #" + carriage.getNumber() + ": ");
            carriage.showConductors();
        }
    }

    public void sortByComfortLevel() {
        Arrays.sort(carriages, Comparator.comparing(Carriage::getComfortLevel));
    }
}
