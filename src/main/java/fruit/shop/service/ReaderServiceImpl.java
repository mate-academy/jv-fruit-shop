package fruit.shop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_LINE = 1;

    @Override
    public List<String> readFromFile(String path) {
        Path filePath = Path.of(path);
        try {
            return Files.readAllLines(filePath).stream()
                    .skip(HEADER_LINE)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file: "
                    + path
                    + ", exception: "
                    + e.getMessage());
        }
    }
}
