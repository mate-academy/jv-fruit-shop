package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public List<String> readCsv(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from File" + path);
        }
    }
}
