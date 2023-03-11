package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.Writer;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(List<String> report, String filePath) {
        try {
            Files.write(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath, e);
        }
    }
}
