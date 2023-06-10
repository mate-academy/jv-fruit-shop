package fruit.shop.impl;

import fruit.shop.service.parser.RecordsParser;
import java.util.ArrayList;
import java.util.List;

public class RecordsParserCommaSeparated implements RecordsParser {
    public static final String SEPARATOR = ",";

    @Override
    public List<String[]> parseRecords(List<String> records) {
        List<String[]> parsedRecords = new ArrayList<>();
        for (String record : records) {
            parsedRecords.add(record.split(SEPARATOR));
        }
        return parsedRecords;
    }
}
