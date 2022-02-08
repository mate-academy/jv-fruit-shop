package dao;

import java.util.List;

public interface FileAccessDaoCsv {
    List<String> readFromFile(String filePath);

    void writeToFile(String stringForReport, String outFilePath);
}
