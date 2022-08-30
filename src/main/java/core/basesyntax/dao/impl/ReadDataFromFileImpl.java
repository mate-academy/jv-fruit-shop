package core.basesyntax.dao.impl;

import core.basesyntax.dao.ReadDataFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    @Override
    public List<String> getFromDatabase(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file " + fileName);
        }
    }
}
