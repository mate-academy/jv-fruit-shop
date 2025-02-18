package dao;

import java.util.Map;

public interface CsvFileWriter {
    void writeFile(String fileName, Map<String, Integer> inventory);
}
