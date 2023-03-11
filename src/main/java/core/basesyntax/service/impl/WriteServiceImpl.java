package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeData(String data, String fileName) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
