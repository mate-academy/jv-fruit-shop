package service;

import java.util.List;

public interface WriterFileService {
    void writeToFile(List<String> lines, String fileName);
}
