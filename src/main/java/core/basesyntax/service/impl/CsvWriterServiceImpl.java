package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, Map<String, Integer> fruitQuantities) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("fruit,quantity\n");

            for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
                String fruit = entry.getKey();
                int quantity = entry.getValue();
                writer.write(fruit + "," + quantity + "\n");
            }

            System.out.println("Fruit quantities have been successfully written to: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error in CsvWriterServiceImpl : ", e);
        }
    }
}
