package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidFileException;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, List<String> content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new InvalidFileException("can`t write content to the file");
        }
    }
}
