package core.basesyntax.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataFileWriter {
    public boolean writeResultsToFile(Map<String, Map<String, Integer>> fruitStore,
                                      String filePath) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> fruitWithAllDates
                : fruitStore.entrySet()) {
            result.add(fruitWithAllDates.getKey() + ","
                    + fruitWithAllDates.getValue().values().stream()
                    .mapToInt(integer -> integer)
                    .sum());
        }
        try {
            Files.write(Path.of(filePath), result);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file, "
                    + "wrong file path or invalid data!");
        }
        return true;
    }
}
