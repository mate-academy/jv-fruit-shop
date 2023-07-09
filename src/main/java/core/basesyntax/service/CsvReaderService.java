package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderService implements DataReaderService {
    private final String path;

    public CsvReaderService(String path) {
        this.path = path;
    }

    @Override
    public List<String> readData() {
        List<String> dataList;
        try {
            dataList = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can not read file");
        }
        dataList.remove(0);
        return dataList;
    }
}
