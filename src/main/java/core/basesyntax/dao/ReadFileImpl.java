package core.basesyntax.dao;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> readFromFile(String path) {
        File file = new File(path);
        try {
            return Files.readAllLines(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException("Can't read file: " + file.getName(), e);
        }
    }
}
