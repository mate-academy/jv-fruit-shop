package fruit.shop.service.parser;

import java.util.List;

public interface RecordsParser {
    List<String[]> parseRecords(List<String> records);
}
