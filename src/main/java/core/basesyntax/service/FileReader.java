package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> readDataFromFile(String fileName) {
        List<String> databaseInfo;
        try {
            String path = this.getClass().getClassLoader().getResource(fileName).getPath();
            databaseInfo = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        return databaseInfo;
    }
}
