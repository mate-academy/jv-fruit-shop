package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeFile(String filePath, String content) {
        try {
            Files.write(Path.of(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
