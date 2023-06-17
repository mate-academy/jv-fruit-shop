package fruit.shop.service.impl;

import fruit.shop.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> getRecords(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! Can't read data from file "
                    + fileName + " ! " + e);
        }
    }
}
