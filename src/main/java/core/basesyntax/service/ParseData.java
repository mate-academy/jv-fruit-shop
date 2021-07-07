package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class ParseData {
    private static final String DATE_REGEXP = "\\d{4}-\\d{2}-\\d{2}";
    private static final String HEADER = "type,fruit,quantity,date";

    public List<Record> parseRecords(List<String> stringList) {
        if (removeHeader(stringList)) {
            List<Record> recordList = new ArrayList<>();
            for (String string : stringList) {
                string = string.trim();
                if (string.matches("[sbr],[a-z]{3,},\\d+," + DATE_REGEXP)) {
                    recordList.add(parseSingleRecord(string));
                } else if (!string.equals("type,fruit,quantity,date")) {
                    throw new RuntimeException("Incorrect line: " + string);
                }
            }
            return recordList;
        }
        throw new RuntimeException("Header line [" + HEADER + "] has not been found");
    }

    private boolean removeHeader(List<String> stringList) {
        String first = stringList.get(0);
        if (first.trim().matches(HEADER)) {
            stringList.remove(first);
            return true;
        }
        return false;
    }

    private Record parseSingleRecord(String string) {
        String[] strings = string.split(",");
        return new Record(strings[0], strings[1], strings[2], strings[3]);
    }
}
