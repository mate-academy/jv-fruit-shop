package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitsFileReader {

    public List<FruitListOperation> read(String filename) {
        List<FruitListOperation> operations = new ArrayList<>();
        try (BufferedReader reader
                     = new BufferedReader(
                             new FileReader("src/main/java/core/basesyntax/" + filename))) {
            reader.readLine(); // пропускаєм перший рядок
            while (reader.ready()) {
                String lineInFile = reader.readLine();
                new FileFruitsValidation().validator(lineInFile, operations);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error!!! Can not read file.", e);
        }
        return operations;
    }
}
