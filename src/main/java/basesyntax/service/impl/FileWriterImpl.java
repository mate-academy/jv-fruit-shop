package basesyntax.service.impl;

import basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String content, String filePath) {
        try {
            Files.write(Path.of(filePath), content.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file: " + filePath, e);
        }
    }
}
