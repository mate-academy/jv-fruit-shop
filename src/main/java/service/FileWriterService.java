package service;

import java.util.List;

public interface FileWriterService {
    void writeToFile(String pathName, List<String> data);
}
