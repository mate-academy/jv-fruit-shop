package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriterService {

    @Override
    public void writeToFile(String filePath, String data) {
        try {
            Files.writeString(new File(filePath).toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + filePath, e);
        }
    }
}
