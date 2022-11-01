package service;

import java.util.List;

public interface WriteToFile {
    boolean writeToFile(String filePath, List<String> report);
}
