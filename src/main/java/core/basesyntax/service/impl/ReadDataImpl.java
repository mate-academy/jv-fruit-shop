package core.basesyntax.service.impl;

import core.basesyntax.service.ReadData;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDataImpl implements ReadData {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + fileName, e);
        }
    }
}
