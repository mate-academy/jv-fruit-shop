package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public String readFromFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + path, e);
        }
    }
}
