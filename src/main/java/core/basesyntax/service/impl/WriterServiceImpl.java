package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean writeToFile(String filePath, String report) {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + filePath, e);
        }
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
        return true;
    }
}
