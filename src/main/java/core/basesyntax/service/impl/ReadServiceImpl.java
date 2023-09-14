package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFromFile(String fileUrl) {
        File file = new File(fileUrl);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file " + file, e);
        }
    }
}
