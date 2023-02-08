package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFileImpl implements ReadFile {
    @Override
    public List<String> readFromFile(String fromFileName) {
        File fileToRead = new File(fromFileName);
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException exc) {
            throw new RuntimeException("Wrong file or path" + fromFileName);
        }
        return fileLines;
    }
}
