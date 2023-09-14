package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderService implements DataReaderService {
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<String> readData(String path) {
        List<String> dataList;
        try {
            dataList = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can not read file. Path:" + path);
        }
        dataList.remove(HEADER_LINE_INDEX);
        return dataList;
    }
}
