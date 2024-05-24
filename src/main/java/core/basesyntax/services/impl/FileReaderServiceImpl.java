package core.basesyntax.services.impl;

import core.basesyntax.services.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String CANT_READ_DATA = "Can't read data from the file: ";

    @Override
    public List<String> read(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_DATA + file, e);
        }
    }
}
