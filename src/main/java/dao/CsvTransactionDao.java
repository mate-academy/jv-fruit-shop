package dao;

import java.util.List;

public interface CsvTransactionDao {
    void createDaoFolder(String folderName);

    void createFile(String fileName, String folderName);

    List<String> readFromFile(String fileName, String folderName);

    void writeToFile(String data, String fileName, String folderName);
}
