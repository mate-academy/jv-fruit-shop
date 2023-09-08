package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeReport(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + filePath);
        }
    }
}
