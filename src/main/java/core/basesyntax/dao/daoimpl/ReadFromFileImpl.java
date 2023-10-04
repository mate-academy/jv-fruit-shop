package core.basesyntax.dao.daoimpl;

import core.basesyntax.dao.ReadFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file: " + fileName, e);
        }
    }
}
