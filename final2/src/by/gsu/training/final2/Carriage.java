package by.gsu.training.final2;

public abstract class Carriage extends RollingStock{
    private int number;
    private final int SEATS;
    private int passengers;

    public Carriage(int yearOfBirth, int number, int SEATS, int passengers) {
        super(yearOfBirth);
        this.number = number;
        this.SEATS = SEATS;
        this.passengers = passengers;
    }

    public int getNumber() {
        return number;
    }

    public int getSEATS() {
        return SEATS;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public abstract ComfortLevel getComfortLevel();
    public abstract void showConductors();

    @Override
    public String toString() {
        return super.toString() +
                ", number=" + number +
                ", seats=" + SEATS +
                ", passengers=" + passengers;
    }
}
