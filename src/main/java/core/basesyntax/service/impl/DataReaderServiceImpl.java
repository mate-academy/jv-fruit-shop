package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {
    @Override
    public List<String> readData(String filePath) {
        File file = new File(filePath);
        List<String> inputData;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            inputData = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return inputData;
    }
}
