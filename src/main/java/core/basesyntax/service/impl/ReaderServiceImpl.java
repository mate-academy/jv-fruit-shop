package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readDataFromFile(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Invalid path to the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file" + file, e);
        }
    }
}
