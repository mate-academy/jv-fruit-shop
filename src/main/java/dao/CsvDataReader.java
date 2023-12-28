package dao;

import java.util.List;

public interface CsvDataReader {
    List<String[]> readDataFromFile(String filePath);
}
