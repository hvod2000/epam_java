package by.gsu.training.final2;

public class Locomotive extends RollingStock {
    private TypeLocomotive type;
    private int maxSpeed;

    public Locomotive(int yearOfBirth, TypeLocomotive type, int maxSpeed) {
        super(yearOfBirth);
        this.type = type;
        this.maxSpeed = maxSpeed;
    }

    public TypeRollingStock getType() {
        return TypeRollingStock.LOCOMOTIVE;
    }

    public TypeLocomotive getLocomotiveType() {
        return this.type;
    }

    public void setLocomotiveType(TypeLocomotive type) {
        this.type = type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", type=" + type + ", maxSpeed=" + maxSpeed;
    }

    public void show() {
        System.out.println(this);
    }
}
