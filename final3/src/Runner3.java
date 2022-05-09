import by.gsu.training.final3.*;

import java.io.FileWriter;
import java.io.IOException;

public class Runner3 {
    public static void main(String[] args) {
        String outputFilePath = "output.txt";
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);
            // 1. Создать одиночные объекты всех классов, умеющих издавать звуки,
            // и записать все изданные ими звуки в заданный файл.
            Dog dog = new Dog();
            Cat cat = new Cat();
            Car car = new Car();
            fileWriter.write("TASK #1\n");
            fileWriter.write(dog.makeSound() + "; ");
            fileWriter.write(cat.makeSound() + "; ");
            fileWriter.write(car.makeSound() + ";\n");

            // 2. Создать массив объектов класса Car и
            // записать все изданные ими звуки в тот же файл.
            Car[] cars = {new Car(), new Car(), new Car()};
            fileWriter.write("TASK #2\n");
            for (Car source: cars) {
                fileWriter.write("A " + source + " tells " + source.makeSound() + "\n");
            }

            // 3. Создать массив объектов классов Dog и Cat
            // (в массиве одновременно должны находиться объекты обоих классов)
            // и записать все изданные ими звуки в тот же файл.
            Animal[] animals = {new Cat(), new Dog(), new Cat()};
            fileWriter.write("TASK #3\n");
            for (Animal source: animals) {
                fileWriter.write("A " + source + " tells " + source.makeSound() + "\n");
            }

            // 4. Создать массив объектов классов Dog, Cat и Car
            // (в массиве одновременно должны находиться объекты всех трёх классов)
            // и записать все изданные ими звуки в тот же файл.
            IMakingSounds[] sources = {new Dog(), new Cat(), new Car()};
            fileWriter.write("TASK #4\n");
            for (IMakingSounds source: sources) {
                fileWriter.write("A " + source + " tells " + source.makeSound() + "\n");
            }

            fileWriter.close();
        } catch (IOException exception) {
            System.err.println("ERROR! Failed to write to file!");
        };
    }
}
