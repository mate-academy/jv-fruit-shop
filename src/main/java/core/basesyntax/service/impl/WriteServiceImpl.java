package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String filePath, String data) {
        try {
            Files.writeString(new File(filePath).toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath, e);
        }

    }
}
