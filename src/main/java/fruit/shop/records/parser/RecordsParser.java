package fruit.shop.records.parser;

import java.util.List;
import java.util.Map;

public interface RecordsParser {
    Map<String, Integer> saveRecordsToMap(List<String> records);
}
