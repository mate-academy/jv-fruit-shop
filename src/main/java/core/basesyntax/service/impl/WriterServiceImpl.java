package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        Path path = Paths.get(filePath);
        byte[] reportToBytes = report.getBytes();

        try {
            Files.write(path, reportToBytes);
        } catch (IOException e) {
            throw new RuntimeException("Try to write to a file was unsuccessful: " + e);
        }
    }
}
