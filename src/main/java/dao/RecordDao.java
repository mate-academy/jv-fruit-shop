package dao;

import java.util.List;

public interface RecordDao {
    List<String> readFile(String fileName);

    void writeFile(String filename, String report);
}
