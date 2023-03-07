package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteServiceImpl implements WriteService {
    @Override
    public void write(String content, String toFile) {
        try {
            Files.writeString(Paths.get(toFile), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + toFile, e);
        }
    }
}
