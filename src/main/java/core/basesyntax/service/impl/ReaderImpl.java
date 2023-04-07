package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFile(String path) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path, e);
        }
        if (dataFromFile.isEmpty()) {
            throw new RuntimeException("No data founded in file " + path);
        }
        return dataFromFile;
    }
}
