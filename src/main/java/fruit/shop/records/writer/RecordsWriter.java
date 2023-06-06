package fruit.shop.records.writer;

import java.util.List;

public interface RecordsWriter {
    void writeRecords(String fileName, List<String> records);
}
