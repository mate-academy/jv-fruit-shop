package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterService implements WriterService {
    @Override
    public void writeReportToCsv(String content, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
}
