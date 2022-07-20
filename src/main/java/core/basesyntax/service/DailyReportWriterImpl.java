package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DailyReportWriterImpl implements DailyReportWriter {
    private static final String FILENAME = "report.csv";
    private final FruitTransaction fruitTransaction = new FruitTransaction();
    private final Map<String, Integer> dailyTurnover = fruitTransaction.getDailyTurnover();

    @Override
    public void write() {
        File report = new File(FILENAME);
        FileWriter writer;

        try {
            writer = new FileWriter(report);
            writer.write("fruit" + ", " + "quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry: dailyTurnover.entrySet()) {
                writer.write(entry.getKey() + ", " + entry.getValue() + System.lineSeparator());
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + FILENAME);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't close file " + FILENAME);
        }
    }
}
