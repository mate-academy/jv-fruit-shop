package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FileReader {

    @Override
    public List<String> readTransactions(String filePath) {
        try {

            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {

            throw new RuntimeException("Error reading file: " + filePath, e);
        }


    }
}
