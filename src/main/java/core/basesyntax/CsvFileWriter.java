package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriter {
    public void writeToFile(String filePath, Map<String, Integer> fruitQuantities, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)) {
            if (!append) {
                writer.write("fruit,quantity\n");
            }
            for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + filePath, e);
        }
    }
}
