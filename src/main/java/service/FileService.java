package service;

import java.util.List;

public interface FileService {
    List<String> readFromFile(String filename);

    void writeToFile(List<String> report, String toFileName);
}
