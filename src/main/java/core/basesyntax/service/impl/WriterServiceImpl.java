package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> list, String filePath) {
        File file = new File(filePath);
        try {
            Files.write(Paths.get(filePath), list);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }
}
