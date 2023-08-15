package core.basesyntax.service.impl;

import core.basesyntax.db.FruitInventory;
import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeToFile(String path) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(REPORT_HEADER);
            writer.flush();
            for (var entry: FruitInventory.getInventory().entrySet()) {
                String lineToWrite = entry.getKey()
                        + "," + entry.getValue()
                        + System.lineSeparator();
                writer.write(lineToWrite);
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to the file", e);
        }
    }
}
