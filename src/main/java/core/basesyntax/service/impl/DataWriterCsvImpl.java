package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataWriterCsvImpl implements DataWriter {
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";

    @Override
    public void write(String data) {
        try {
            Files.write(Path.of(REPORT_PATH), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data to file:" + REPORT_PATH);
        }
    }
}
