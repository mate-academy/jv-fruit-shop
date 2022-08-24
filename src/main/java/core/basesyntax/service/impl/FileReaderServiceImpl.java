package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathName) {
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file named: " + pathName, e);
        }
        return readFromFile;
    }
}
