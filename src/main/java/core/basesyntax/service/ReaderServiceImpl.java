package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String dailyReport) {
        List<String> dataFromFile;
        {
            try {
                dataFromFile = Files.readAllLines(Paths.get(dailyReport));
            } catch (IOException e) {
                throw new RuntimeException("Can't read file", e);
            }
        }
        return dataFromFile;
    }
}
