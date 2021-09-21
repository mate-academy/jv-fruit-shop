package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> getDataFromFile(String filePath) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath);
        }
        return data;
    }
}
