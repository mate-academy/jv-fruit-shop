package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, List<String> data) {
        try {
            Files.write(Path.of(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file" + filePath, e);
        }
    }
}
