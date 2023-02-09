package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String date) {
        try {
            Files.writeString(Path.of(OUTPUT_FILE_PATH), date);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + OUTPUT_FILE_PATH, e);
        }
    }
}
