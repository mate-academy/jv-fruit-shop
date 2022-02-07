package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReaderImpl implements DataReader {

    @Override
    public List<String> readFromFile(String dataFromFile) {
        try {
            return Files.readAllLines(Paths.get(dataFromFile));
        } catch (IOException e) {
            throw new RuntimeException("You can`t read current file", e);
        }
    }
}
