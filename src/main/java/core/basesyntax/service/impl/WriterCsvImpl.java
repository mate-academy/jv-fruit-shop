package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterCsvImpl implements Writer {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_database.csv";

    @Override
    public void writeToFile(String report) {
        try {
            Files.write(Path.of(OUTPUT_FILE_PATH), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + OUTPUT_FILE_PATH, e);
        }
    }
}
