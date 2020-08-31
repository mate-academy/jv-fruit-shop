package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvFileWriter {
    public boolean writeToFile(Map<String, Map<String, Integer>> fruitStore, String outputFile) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> data : fruitStore.entrySet()) {
            result.add(data.getKey() + "," + data.getValue().values()
                    .stream()
                    .mapToInt(x -> x)
                    .sum());
        }
        try {
            Files.write(Path.of(outputFile), result);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file!", e);
        }
        return true;
    }
}
