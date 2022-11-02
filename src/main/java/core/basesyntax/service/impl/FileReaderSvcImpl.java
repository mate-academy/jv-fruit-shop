package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderSvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderSvcImpl implements FileReaderSvc {
    private final Path filePath;

    public FileReaderSvcImpl(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Unable to read file \"%s\" ", filePath) + e
            );
        }
        return lines;
    }
}
