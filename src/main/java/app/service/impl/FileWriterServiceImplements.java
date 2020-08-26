package app.service.impl;

import app.FruitStorage;
import app.model.Fruit;
import app.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriterServiceImplements implements FileWriterService {
    public static final String FILE_PATH = "C:\\Users\\38093\\Desktop\\Mate academy"
            + "\\jv-fruit-shop_prod" + "\\src\\main\\java\\resources\\result.csv";
    public static final String SEPARATOR = ",";
    
    @Override
    public boolean writeData() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            if (FruitStorage.fruits.size() == 0) {
                return false;
            }
            int numberOfCurrentProducts = 0;
            writer.append("fruit").append(SEPARATOR).append("quantity")
                    .append(System.lineSeparator());
            Map<String, List<Fruit>> resultList = FruitStorage.fruits.stream()
                    .collect(Collectors.groupingBy(Fruit::getName));
            for (Map.Entry<String, List<Fruit>> resultElement : resultList.entrySet()) {
                writer.append(resultElement.getKey()).append(SEPARATOR);
                for (Fruit fruit : resultElement.getValue()) {
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
