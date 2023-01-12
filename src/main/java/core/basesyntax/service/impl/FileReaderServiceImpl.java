package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathToFileForRead) {
        try {
            return Files.readAllLines(Path.of(pathToFileForRead));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + pathToFileForRead, e);
        }
    }
}
