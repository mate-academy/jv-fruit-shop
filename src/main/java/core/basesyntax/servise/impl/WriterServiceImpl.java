package core.basesyntax.servise.impl;

import core.basesyntax.servise.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToCsv(String resultFilePath, String report) {
        try {
            Files.write(Path.of(resultFilePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file ", e);
        }
    }
}
