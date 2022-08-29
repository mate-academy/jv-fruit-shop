package core.basesyntax;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File folder = new File("src\\main\\java\\core\\basesyntax\\resources");
        File inputFile = new File(folder, "input.csv");

        File outputFile = new File(folder, "output.csv");
        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Output file not created", e);
            }
        }
    }
}
