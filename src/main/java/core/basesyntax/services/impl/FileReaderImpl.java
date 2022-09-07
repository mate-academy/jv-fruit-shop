package core.basesyntax.services.impl;

import core.basesyntax.services.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    public List<String> readFromFile(String fromFile) {
        try {
            return Files.readAllLines(Paths.get(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("file " + fromFile + " could not be read", e);
        }
    }
}
