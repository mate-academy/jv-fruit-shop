package service;

import dao.TransactionsDao;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import model.FruitTransaction;

public class CsvReportGeneratorService implements Exporter {
    private final TransactionsDao transactionsDao;

    public CsvReportGeneratorService(TransactionsDao transactionsDao) {
        this.transactionsDao = transactionsDao;
    }

    @Override
    public void exportToCsv(String fileName) {
        String filePath = Paths.get("src", "main", "resources", fileName).toString();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("fruit,quantity\n");
            for (FruitTransaction fruit : transactionsDao.getAll()) {
                writer.append(fruit.getFruit())
                        .append(",")
                        .append(String.valueOf(fruit.getQuantity()))
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file: " + filePath, e);
        }
    }
}
