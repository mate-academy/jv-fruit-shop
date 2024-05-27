package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriterService {
    @Override
    public void writeToFile(String record, Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(record);
        } catch (IOException e) {
            throw new RuntimeException("Can`t create a file", e);
        }
    }
}
