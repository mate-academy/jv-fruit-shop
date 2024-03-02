package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadDataImpl implements ReadData {
    @Override
    public List<String> readDataFromFile() {
        try {
            return Files.readAllLines(Paths.get("src/main/java/StartInfo.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
