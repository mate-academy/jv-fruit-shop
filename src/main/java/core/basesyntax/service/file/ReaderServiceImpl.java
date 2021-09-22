package core.basesyntax.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("The file could not be read: " + filePath, e);
        }
        return data;
    }
}
