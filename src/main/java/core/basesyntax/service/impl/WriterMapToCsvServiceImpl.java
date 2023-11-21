package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterMapToCsvServiceImpl implements WriterService<String> {
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    @Override
    public void writeReport(String dataType) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(REPORT_FILE))) {
            writer.write(dataType);
        } catch (IOException e) {
            throw new RuntimeException("File " + REPORT_FILE + " not found");
        }
    }
}
