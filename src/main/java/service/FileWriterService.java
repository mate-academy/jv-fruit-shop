package service;

import java.util.List;

public interface FileWriterService {
    void writeFile(String filePath, List<String[]> message);
}
