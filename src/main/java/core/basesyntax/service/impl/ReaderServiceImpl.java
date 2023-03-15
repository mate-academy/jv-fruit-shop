package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String pathToFile) {
        File file = new File(pathToFile);
        try {
            return Files.readAllLines(file.toPath());
        } catch (FileNotFoundException e){
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
