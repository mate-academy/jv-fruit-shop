package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String fileName, String text) {
        try {
            Files.write(Path.of(fileName), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + fileName,e);
        }
    }
}
