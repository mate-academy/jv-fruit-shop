package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String fileName, String data) {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + path, e);
        }
    }
}
