package service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String fromInputFile);

    void writeToReportFile(String informationString, String fromFilePath);
}
