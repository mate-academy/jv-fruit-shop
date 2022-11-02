package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private final Path filePath;

    public FileReaderServiceImpl(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Unable to read file \"%s\" ", filePath), e);
        }
        return lines;
    }
}
