package core.basesyntax.writer;

import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterImpl implements Writer {
    private static final String CSV_SEPARATOR = ",";
    private static final String FRUITS_TITLE = "fruit";
    private static final String QUANTITY_TITLE = "quantity";
    private String reportFilePath;

    public WriterImpl(String reportFilePath) {
        if (reportFilePath == null) {
            throw new RuntimeException("File path can not be null.");
        }
        this.reportFilePath = reportFilePath;
    }

    @Override
    public void write(List<Fruit> fruits) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File(reportFilePath))
        )) {
            bufferedWriter.write(FRUITS_TITLE + CSV_SEPARATOR
                            + QUANTITY_TITLE + System.lineSeparator());
            bufferedWriter.flush();
            for (Fruit fruit : fruits) {
                bufferedWriter.write(fruit.getFruitName() + CSV_SEPARATOR
                            + fruit.getAmount() + System.lineSeparator());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException when write to " + reportFilePath, e);
        }
    }
}
