package core.basesyntax.store.io.reader;

import core.basesyntax.store.io.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            Logger.logError("Error reading file: " + fileName, e); // Логуємо помилку
            return Collections.emptyList();
        }
    }
}
