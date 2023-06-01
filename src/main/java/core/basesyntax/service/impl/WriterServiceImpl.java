package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeDataToFile(String fileName, List<String> data) {
        Path file = Path.of(fileName);
        try {
            Files.write(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}

