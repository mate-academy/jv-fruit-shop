package fruitOperationManagers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FruitOperationManagerCsvImpl implements FruitOperationManager {
    private final String csvFilePath;

    public FruitOperationManagerCsvImpl(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public List<String> getAllOperations() {
        try {
            return Files.readAllLines(Path.of(csvFilePath)).stream()
                    .skip(1)
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + csvFilePath);
        }
    }
}
