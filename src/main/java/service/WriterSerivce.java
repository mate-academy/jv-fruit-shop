package service;

import java.util.Map;

public interface WriterSerivce {
    void writeToFile(String outputFilePath, Map<String, Integer> fruitCounts);
}
