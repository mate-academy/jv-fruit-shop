package core.basesyntax.fileservice;

import java.util.List;
import java.util.Map;

public interface FileService {
    List<String[]> readFromFile(String filePath);

    void writeToFile(Map<String, Integer> balance, String filePath);
}