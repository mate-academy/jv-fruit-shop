package app.service.impl;

import app.model.SupplyFruit;
import app.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriterServiceImplementation implements FileWriterService {
    public static final String SEPARATOR = ",";
    
    @Override
    public boolean writeData(List<SupplyFruit> fruits, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            if (fruits.size() == 0) {
                return false;
            }
            int numberOfCurrentProducts = 0;
            writer.append("fruit").append(SEPARATOR).append("quantity")
                    .append(System.lineSeparator());
            Map<String, List<SupplyFruit>> resultList = fruits.stream()
                    .collect(Collectors.groupingBy(SupplyFruit::getFruitName));
            for (Map.Entry<String, List<SupplyFruit>> resultElement : resultList.entrySet()) {
                writer.append(resultElement.getKey()).append(SEPARATOR);
                for (SupplyFruit fruit : resultElement.getValue()) {
                    numberOfCurrentProducts += fruit.getQuantity();
                }
                writer.append(String.valueOf(numberOfCurrentProducts))
                        .append(System.lineSeparator());
                numberOfCurrentProducts = 0;
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to write result to file: " + e.getMessage());
        }
        return true;
    }
}
