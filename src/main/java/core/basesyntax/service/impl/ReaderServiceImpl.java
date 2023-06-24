package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + file.getName(), e);
        }
        return lines;
    }
}
