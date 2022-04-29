package by.gsu.training.final2;

public abstract class RollingStock {
    private final int YEAR_OF_BIRTH;

    public RollingStock(int yearOfBirth) {
        this.YEAR_OF_BIRTH = yearOfBirth;
    }

    public int getYEAR_OF_BIRTH() {
        return YEAR_OF_BIRTH;
    }

    public abstract TypeRollingStock getType();
    public abstract void show();

    @Override
    public String toString() {
        return this.getType() + ": YEAR_OF_BIRTH=" + YEAR_OF_BIRTH;
    }
}
