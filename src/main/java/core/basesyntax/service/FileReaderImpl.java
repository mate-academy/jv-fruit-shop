package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> allData = new ArrayList<>();
        try {
            allData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + Path.of(fileName), e);
        }
        return allData;
    }
}
