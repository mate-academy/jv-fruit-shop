package core.basesyntax.services.impl;

import core.basesyntax.services.interfaces.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file: " + file);
        }
    }
}
