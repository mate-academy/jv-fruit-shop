package core.basesyntax.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import core.basesyntax.service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReport(String report, String fileName) {
        try {
            Files.write(new File(fileName).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
