package dao;

import java.util.List;

public interface CustomFileReader {
    List<String[]> readFile(String filePath);
}
