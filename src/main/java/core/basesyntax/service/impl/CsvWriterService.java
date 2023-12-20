package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterService implements WriterService {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    @Override
    public void writeToCsv(String content, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
}
