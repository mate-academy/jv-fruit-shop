package fruitshop.service.impl;

import fruitshop.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        List<String> inputData;
        try {
            inputData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + file);
        }
        return inputData;
    }
}
