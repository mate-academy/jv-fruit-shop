package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public String readFromFile(String fromFileName) {
        try {
            return Files.readString(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + fromFileName);
        }
    }
}
