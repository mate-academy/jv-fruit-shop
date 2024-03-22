package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidFileException;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))) {
            writer.write(content);
        } catch (IOException e) {
            throw new InvalidFileException("Can`t write content to the file: " + path);
        }
    }
}
