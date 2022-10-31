package core.fruitshop.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileWorker {
    List<String> readFromFile(String fileName) throws IOException;

    void writeToFile(String fileName, String header,
                     String columnSeparator, Map<String, Integer> data) throws IOException;
}
