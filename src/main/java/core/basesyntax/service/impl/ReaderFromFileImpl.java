package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderFromFileImpl implements Reader {
    private List<String> dataFromFile;

    @Override
    public List<String> readFromFile(String inputFile) {
        try {
            Path path = Path.of(inputFile);
            dataFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file: " + inputFile, e);
        }
        return dataFromFile;
    }
}
