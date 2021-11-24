package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterImpl implements Writer {

    @Override
    public void writeToFile(List<String> report, String filePath) {
        try {
            Files.write(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Data can not be written" + filePath, e);
        }
    }
}
