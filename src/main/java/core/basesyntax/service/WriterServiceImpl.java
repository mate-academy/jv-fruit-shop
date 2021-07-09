package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.writeString(new File(fileName).toPath(), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
