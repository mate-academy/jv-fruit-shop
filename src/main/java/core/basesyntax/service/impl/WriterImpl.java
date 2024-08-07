package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer {
    private static final String REPORT_HEAD_LINE = "fruit,quantity";
    private static final char COMMA = ',';

    @Override
    public void createReport(String reportPath) {
        File report = new File(reportPath);
        StringBuilder reportText = new StringBuilder(REPORT_HEAD_LINE);
        for (Map.Entry<String, Fruit> fruit : Storage.fruits.entrySet()) {
            String fruitName = fruit.getValue().getFruitName();
            int quantity = fruit.getValue().getQuantity();
            reportText.append("\n").append(fruitName).append(COMMA).append(quantity);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write(reportText.toString());
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file: " + reportPath, e);
        }
    }
}
