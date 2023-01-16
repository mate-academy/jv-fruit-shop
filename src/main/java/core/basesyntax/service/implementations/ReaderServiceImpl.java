package core.basesyntax.service.implementations;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String FILE_PATH = "src/main/resources/dayInStore.csv";

    @Override
    public List<String> readFromFile() {
        try {
            return Files.readAllLines(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILE_PATH);
        }
    }
}
