package service.impl;

import db.ShopStorage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.ReportGeneratorService;

public class CsvReportGeneratorService implements ReportGeneratorService {
    private final ShopStorage fruitStorage;

    public CsvReportGeneratorService(ShopStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void generateReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("fruit,quantity");
            writer.newLine();
            for (Map.Entry<String, Integer> entry : fruitStorage.getFruitQuantities().entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
