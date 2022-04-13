package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeLines(String filePath, List<String> records) {
        Path path = new File(filePath).toPath();
        try {
            Files.write(path, records);
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file " + filePath, e);
        }
    }
}
