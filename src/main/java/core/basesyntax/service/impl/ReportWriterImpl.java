package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String report, String fileName) {
        File fruitReport = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fruitReport))) {
            writer.write(HEADER);
            for (String line : report.split(";")) {
                writer.newLine();
                writer.write(line);
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
