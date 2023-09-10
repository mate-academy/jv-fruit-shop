package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readDataFromTheFile(String path) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + path);
        }
        return data;
    }
}
