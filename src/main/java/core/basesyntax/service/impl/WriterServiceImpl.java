package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeDataToFile(String data) {
        try {
            Files.writeString(Path.of(REPORT_FILE_PATH), data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + REPORT_FILE_PATH, e);
        }
    }
}
