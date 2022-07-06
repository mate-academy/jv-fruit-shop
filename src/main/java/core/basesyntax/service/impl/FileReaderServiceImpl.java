package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathToFile) {
        File fileToPath = new File(pathToFile);
        try {
            return Files.readAllLines(fileToPath.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
    }
}
