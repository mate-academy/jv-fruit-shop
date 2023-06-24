package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String readFile(String nameOfFile) {
        try {
            return Files.readString(Path.of(nameOfFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + nameOfFile, e);
        }
    }
}
