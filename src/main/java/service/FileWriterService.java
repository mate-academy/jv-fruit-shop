package service;

import java.util.List;

public interface FileWriterService {
    void writeIntoFile(List<String> report, String fileName);
}
