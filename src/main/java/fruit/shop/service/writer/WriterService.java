package fruit.shop.service.writer;

import java.util.Map;

public interface WriterService {
    void writeRecordsToFile(String fileName, Map<String, Integer> records);
}
