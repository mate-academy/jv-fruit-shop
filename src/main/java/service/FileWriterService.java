package service;

import java.util.List;

public interface FileWriterService {
    boolean writeToFile(String filePath, List<String> report);
}
