package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.MyWriter;

public class MyWriterImpl implements MyWriter {
    @Override
    public void writeToFile(List<String> report, String filePath) {
        try {
            Files.write(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file" + filePath, e);
        }
    }
}
