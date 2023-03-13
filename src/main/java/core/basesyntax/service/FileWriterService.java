package core.basesyntax.service;

import core.basesyntax.exception.FruitException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterService {
    public static void writeToFile(String fileName, String data) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new FruitException("Can't write to file: " + fileName);
        }
    }
}
