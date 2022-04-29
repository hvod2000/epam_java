package by.gsu.training.final2;

public class EconomCarriage extends Carriage{
    private String firstConductor;
    private String secondConductor;

    public EconomCarriage(int yearOfBirth, int number, int PLACES, int passengers, String firstConductor, String secondConductor) {
        super(yearOfBirth, number, PLACES, passengers);
        this.firstConductor = firstConductor;
        this.secondConductor = secondConductor;
    }

    public String getFirstConductor() {
        return firstConductor;
    }

    public String getSecondConductor() {
        return secondConductor;
    }

    @Override
    public ComfortLevel getComfortLevel() {
        return ComfortLevel.ECONOM;
    }

    @Override
    public void showConductors() {
        System.out.println("Conductors: " + firstConductor + ", " + secondConductor);
    }

    @Override
    public TypeRollingStock getType() {
        return TypeRollingStock.ECONOM;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", firstConductor='" + firstConductor + '\'' +
                ", secondConductor='" + secondConductor + '\'';
    }
}
