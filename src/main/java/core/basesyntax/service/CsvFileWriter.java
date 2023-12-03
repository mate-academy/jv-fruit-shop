package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CsvFileWriter implements FileWriter {
    @Override
    public boolean write(String fileContent, String toFileName) {
        try {
            Path filePath = Path.of(toFileName);
            Files.writeString(filePath, fileContent, StandardOpenOption.CREATE,
                     StandardOpenOption.WRITE);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
