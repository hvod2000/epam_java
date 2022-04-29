package by.gsu.training.final2;

public class CompartmentCarriage extends Carriage{
    private final int COUPE_SEATS;
    private String conductor;

    public CompartmentCarriage(int yearOfBirth, int number, int PLACES, int passengers, int COUPE_SEATS, String conductor) {
        super(yearOfBirth, number, PLACES, passengers);
        this.COUPE_SEATS = COUPE_SEATS;
        this.conductor = conductor;
    }

    public int getCOUPE_SEATS() {
        return COUPE_SEATS;
    }

    public String getConductor() {
        return conductor;
    }

    @Override
    public void showConductors() {
        System.out.println("Conductors: " + conductor);
    }

    @Override
    public ComfortLevel getComfortLevel() {
        return ComfortLevel.COMPARTMENT;
    }

    @Override
    public TypeRollingStock getType() {
        return TypeRollingStock.COMPARTMENT;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", coupeSeats=" + COUPE_SEATS +
                ", conductor='" + conductor + '\'';
    }
}
