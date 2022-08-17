package core.basesyntax.service.csvfileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file" + file, e);
        }
        return lines;
    }
}
