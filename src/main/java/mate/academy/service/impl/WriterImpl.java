package mate.academy.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import mate.academy.service.Writer;

public class WriterImpl implements Writer {
    public void writeToFile(String fileContent, String filePath) {
        try {
            Files.write(Path.of(filePath), fileContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
