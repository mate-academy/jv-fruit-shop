package service;

import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> report, String filename);
}
