package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface DailyReportFileWriter {
    void writeDailyStatistic(Path path, String data);

    default void validateReportFile(Path path) {
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't validate file: " + path, e);
        }
    }
}
