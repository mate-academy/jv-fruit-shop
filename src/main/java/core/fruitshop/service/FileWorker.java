package core.fruitshop.service;

import java.util.List;
import java.util.Map;

public interface FileWorker {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, String header,
                     String columnSeparator, Map<String, Integer> data);
}
