package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderFileImpl implements ReaderFile {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> listFileRead;
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
