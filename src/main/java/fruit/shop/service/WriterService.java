package fruit.shop.service;

import java.util.Map;

public interface WriterService {
    void writeRecordsToFile(String fileName, Map<String, Integer> records);
}
