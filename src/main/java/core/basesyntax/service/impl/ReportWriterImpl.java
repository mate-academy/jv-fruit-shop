package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeToFile(List<String> report, String fileName) {
        File fruitReport = new File(fileName);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fruitReport));
            writer.write("fruit,quantity");
            for (String line : report) {
                writer.newLine();
                writer.write(line);
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
