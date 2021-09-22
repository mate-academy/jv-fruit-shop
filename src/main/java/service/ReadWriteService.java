package service;

import java.util.List;

public interface ReadWriteService {
    List<String> readFromFile(String fromInputFile);

    void writeToReportFile(String informationString, String fromFilePath);
}
