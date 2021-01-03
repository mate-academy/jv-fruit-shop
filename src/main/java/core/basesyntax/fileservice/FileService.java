package core.basesyntax.fileservice;

import java.util.List;

public interface FileService {
    List<String[]> readFromFile(String filePath);

    void writeToFile(List<String[]> records, String filePath);
}
