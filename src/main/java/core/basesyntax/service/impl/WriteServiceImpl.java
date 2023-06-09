package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriteService {
    private static final String REPORT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/report.scv";

    @Override
    public void writeReport(String report) {
        try {
            Files.writeString(Path.of(REPORT_FILE_PATH), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + REPORT_FILE_PATH);
        }
    }
}
