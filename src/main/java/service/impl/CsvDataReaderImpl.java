package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.DataReader;

public class CsvDataReaderImpl implements DataReader {
    @Override
    public List<String> getDataFromFile(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path " + filePath, e);
        }
        if (!lines.isEmpty()) {
            lines.remove(0);
        }
        return lines;
    }
}
