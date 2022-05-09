package by.gsu.training.final3;

import java.io.FileWriter;
import java.io.IOException;

public class KeeperSounds {
    public static void speakToFile(IMakingSounds[] sources, FileWriter file) throws IOException {
        for (IMakingSounds source: sources) {
            file.write("A " + source + " tells " + source.makeSound() + "\n");
        }
    }
}
