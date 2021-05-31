package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> readDataFromFile(String fileName) {
        List<String> databaseInfo;
        try {
            databaseInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        return databaseInfo;
    }
}
