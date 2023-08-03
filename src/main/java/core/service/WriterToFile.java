package core.service;

import java.util.List;

public interface WriterToFile {
    void writeToFileData(List<String> report, String filePath);
}
