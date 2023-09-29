package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private static final String OUTPUT_FILE
            = "src/main/java/core/basesyntax/resources/outputFile.csv";

    @Override
    public void writeToFile(String date) {
        try {
            Files.writeString(Path.of(OUTPUT_FILE), date);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + OUTPUT_FILE, e);
        }
    }
}
