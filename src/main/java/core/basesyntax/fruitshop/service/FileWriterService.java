package core.basesyntax.fruitshop.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterService {
    public void writeReportToFile(Map<String, Integer> fruitInventory,
                                  String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new IOException("Error writing report to file", e);
        }
    }
}
