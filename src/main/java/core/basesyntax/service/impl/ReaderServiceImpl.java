package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data;
        try {
            data = Files.readAllLines(new File(filePath).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file" + filePath, e);
        }
        return data;
    }
}
