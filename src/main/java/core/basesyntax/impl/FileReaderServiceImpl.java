package core.basesyntax.impl;

import core.basesyntax.servise.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        }
        return dataFromFile;
    }
}
