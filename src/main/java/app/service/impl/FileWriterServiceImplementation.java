package app.service.impl;

import app.model.SupplyFruitBatch;
import app.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriterServiceImplementation implements FileWriterService {
    private static final String SEPARATOR = ",";
    private static final String HEADER_FRUIT = "fruit";
    private static final String HEADER_QUANTITY = "quantity";

    @Override
    public boolean writeData(List<SupplyFruitBatch> fruits, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            if (fruits.size() == 0) {
                return false;
            }
            writer.append(HEADER_FRUIT).append(SEPARATOR).append(HEADER_QUANTITY)
                    .append(System.lineSeparator());
            Map<String, List<SupplyFruitBatch>> resultList = fruits.stream()
                    .collect(Collectors.groupingBy(SupplyFruitBatch::getFruitName));
            for (Map.Entry<String, List<SupplyFruitBatch>> resultElement : resultList.entrySet()) {
                int numberOfCurrentProducts = 0;
                writer.append(resultElement.getKey()).append(SEPARATOR);
                for (SupplyFruitBatch fruit : resultElement.getValue()) {
                    numberOfCurrentProducts += fruit.getQuantity();
                }
                writer.append(String.valueOf(numberOfCurrentProducts))
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to write result to file: " + e.getMessage());
        }
        return true;
    }
}
