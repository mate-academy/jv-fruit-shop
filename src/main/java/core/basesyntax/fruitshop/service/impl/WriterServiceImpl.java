package core.basesyntax.fruitshop.service.impl;

import core.basesyntax.fruitshop.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReport(Map<String, Integer> fruitInventory,
                            String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file" + filePath, e);
        }
    }
}
