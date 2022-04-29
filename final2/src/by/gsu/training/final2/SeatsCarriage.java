package by.gsu.training.final2;

public class SeatsCarriage extends Carriage{
    private TypeSeats seatsType;

    public SeatsCarriage(int yearOfBirth, int number, int PLACES, int passengers, TypeSeats seatsType) {
        super(yearOfBirth, number, PLACES, passengers);
        this.seatsType = seatsType;
    }

    public TypeSeats getSeatsType() {
        return seatsType;
    }

    @Override
    public ComfortLevel getComfortLevel() {
        if (seatsType == TypeSeats.HARD) {
            return ComfortLevel.HARD_SEAT;
        } else {
            return ComfortLevel.SOFT_SEAT;
        }
    }

    @Override
    public void showConductors() {
        System.out.println("Conductors: NONE");
    }

    @Override
    public TypeRollingStock getType() {
        return TypeRollingStock.SEATING;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", seatsType=" + seatsType;
    }
}