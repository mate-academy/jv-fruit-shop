package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathFile) {
        try {
            return Files.readAllLines(new File(pathFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + pathFile, e);
        }
    }
}
