package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, Path filePath) {
        try {
            Files.writeString(filePath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path:" + filePath, e);
        }
    }
}
