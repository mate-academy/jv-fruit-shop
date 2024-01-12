package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterOwn;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriterOwn<String> {

    @Override
    public void write(List<String> data, String fileName) {
        try {
            Files.write(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
