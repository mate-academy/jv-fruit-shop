package dao;

import java.util.List;

public interface FileReaderDao {
    List<String> getDataFile(String fileName);
}
