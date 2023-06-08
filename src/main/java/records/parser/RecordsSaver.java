package records.parser;

import java.util.List;
import java.util.Map;

public interface RecordsSaver {
    Map<String, Integer> saveRecordsToMap(List<String> records);
}
