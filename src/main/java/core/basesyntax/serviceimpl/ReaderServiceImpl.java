package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String pathToInputFile) {
        File inputFile = new File(pathToInputFile);
        try {
            return Files.readAllLines(Path.of(pathToInputFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + pathToInputFile);
        }
    }
}
