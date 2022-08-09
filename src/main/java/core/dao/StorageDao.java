package core.dao;

import java.util.List;

public interface StorageDao {
    List<String> readData(String fileName);

    void writeData(String fileName, String data);
}
