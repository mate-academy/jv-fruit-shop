package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceFromFileImpl implements ReaderService {
    private List<String> dataFromFile;

    @Override
    public void readFromFile(String inputFile) {
        try {
            Path path = Path.of(inputFile);
            dataFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file",e);
        }
    }

    @Override
    public List<String> getData() {
        return dataFromFile;
    }
}
