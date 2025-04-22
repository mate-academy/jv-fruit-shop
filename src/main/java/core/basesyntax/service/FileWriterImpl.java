package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    private static final String OUTPUT_FILE = "src/main/resources/fruit_shop_output.csv";

    @Override
    public void write(String report) {
        try {
            Files.write(Path.of(OUTPUT_FILE), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + OUTPUT_FILE, e);
        }
    }
}
