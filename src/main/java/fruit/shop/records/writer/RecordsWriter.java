package fruit.shop.records.writer;

import java.util.List;
import java.util.Map;

public interface RecordsWriter {
    void writeRecords(String fileName, Map<String, Integer> records);
}
