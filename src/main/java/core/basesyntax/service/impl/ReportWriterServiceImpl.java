package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReportWriterServiceImpl implements ReportWriterService {
    @Override
    public void writeReport(String report, String path) {
        try {
            Files.writeString(Path.of(path), report, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file by path: " + path, e);
        }
    }
}
