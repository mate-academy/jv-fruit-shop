package service;

import java.util.List;

public interface WritingIntoCsvFileService {
    void writeIntoFile(List<String> report, String fileName);
}
