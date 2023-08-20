package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String fileName, String data) {
        try {
            Files.write(new File(fileName).toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + fileName, e);
        }
    }
}
