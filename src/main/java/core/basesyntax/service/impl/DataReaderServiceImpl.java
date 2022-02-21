package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {

    @Override
    public List<String> readDataFromFile(String filepath) {
        try {
            return Files.readAllLines(Paths.get(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find a file: " + filepath);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + filepath);
        }
    }
}
