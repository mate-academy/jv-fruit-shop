package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public void writeReportToFile(String report, String outputPath) {
        try {
            Files.writeString(Path.of(outputPath), report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot reach file by " + outputPath, e);
        }
    }
}
