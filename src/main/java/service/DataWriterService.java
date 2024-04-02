package service;

import java.util.Map;

public interface DataWriterService {
    void writeProcessedDataToFile(String fileName, Map<String, Integer> data);
}
