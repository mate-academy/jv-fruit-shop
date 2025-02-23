package dao;

import java.util.List;

public interface CustomFileWriter {
    void writeFile(String filePath, List<String[]> data);
}
