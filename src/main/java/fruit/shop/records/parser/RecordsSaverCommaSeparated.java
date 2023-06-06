package fruit.shop.records.parser;

import java.util.List;
import java.util.Map;

public class RecordsSaverCommaSeparated implements RecordsSaver {
    @Override
    public Map<String, Integer> saveRecordsToMap(List<String> records) {
        for (String r : records) {
            String[] options = r.split(",");

        }
    }
}
