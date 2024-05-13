package core.basesyntax.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CsvWriter {
    public static void writeReport(String path, String report) {
        try (FileWriter writer = new FileWriter(Path.of(path).toFile())) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + path, e);
        }
    }
}
