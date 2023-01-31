package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try {
            dataFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can not get data from " + filePath);
        }
        return dataFromFile;
    }
}
