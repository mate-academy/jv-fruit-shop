package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String fileFrom) {
        File file = new File(fileFrom);
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileFrom));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read date from file " + file.getName(), e);
        }
        return lines;
    }
}
