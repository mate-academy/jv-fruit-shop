package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl implements FileWriter {
    @Override
    public Boolean write(String report, Path filePath) {
        try {
            if (Files.deleteIfExists(filePath)) {
                Files.createFile(filePath);
            }
            Files.write(filePath, report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in file: " + "'" + filePath + "'.", e);
        }
        return filePath.toFile().canRead();
    }
}
