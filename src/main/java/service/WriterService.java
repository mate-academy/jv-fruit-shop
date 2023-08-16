package service;

import java.util.List;

public interface WriterService {
    void writeToFile(String fileName, List<String> data);
}
