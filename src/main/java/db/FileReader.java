package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> readFromFile(String pathName) {
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file " + pathName, e);
        }
        return readFromFile;
    }
}
