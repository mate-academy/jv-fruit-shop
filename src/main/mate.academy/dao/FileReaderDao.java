package dao;

import java.util.List;

public interface FileReaderDao {
    List<String> getFileData(String fileName);
}
