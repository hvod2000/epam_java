package by.gsu.training.final3;

public class Car implements IMakingSounds {
    @Override
    public String makeSound() {
        return "beep-boop-beep";
    }

    @Override
    public String toString() {
        return "car";
    }
}
