package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException ex) {
            throw new RuntimeException("Can't find file by path: " + filePath, ex);
        }
    }
}
