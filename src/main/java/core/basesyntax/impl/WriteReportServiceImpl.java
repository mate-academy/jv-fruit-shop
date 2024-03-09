package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriteReportService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteReportServiceImpl implements WriteReportService {
    private static final String DELIMITER = ",";

    @Override
    public void writeReport(List<Fruit> fruitDb, String filePath) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write("fruit,quantity");
            for (Fruit fruit : fruitDb) {
                bufferedWriter.newLine();
                bufferedWriter.write(fruit.getFruit() + DELIMITER);
                bufferedWriter.write(String.valueOf(fruit.getQuantity()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file", e);
        }
    }
}
