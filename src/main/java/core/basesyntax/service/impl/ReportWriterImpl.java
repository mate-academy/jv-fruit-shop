package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class ReportWriterImpl implements ReportWriter {
    private static final String CSV_SPLITTER = ",";
    private static final String FRUIT_HEADER = "fruit";
    private static final String QUANTITY_HEADER = "quantity";

    @Override
    public void writeReport(String path) {
        writeToFile(Path.of(path), createReport());
    }

    private String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FRUIT_HEADER)
                .append(CSV_SPLITTER)
                .append(QUANTITY_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(CSV_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }

    private void writeToFile(Path path, String data) {
        try {
            Files.writeString(path, data, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + path);
        }
    }
}
