package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitException;
import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterService implements WriterService {
    @Override
    public void write(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new FruitException("Can't write to file: " + fileName);
        }
    }
}
