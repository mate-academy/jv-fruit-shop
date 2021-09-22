package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class RecordParser {
    private static final int OPERATION_INDEX = 0;
    private static final String COMA = ",";
    private static final String NEW_LINE = "\n";

    public List<Record> parseRecords(String records) {
        String[] recordsAsStringArray = records.split(NEW_LINE);
        List<Record> recordList = new ArrayList<>();
        for (String record : recordsAsStringArray) {
            String activity = getActivityFromRecordString(record);
            String fruitName = getFruitNameFromRecordString(record);
            int amount = getAmountFromRecordString(record);
            Record localRecord = new Record(activity, fruitName, amount);
            recordList.add(localRecord);
        }
        return recordList;
    }

    private String getActivityFromRecordString(String inputRecord) {
        return String.valueOf(inputRecord.charAt(OPERATION_INDEX));
    }

    private String getFruitNameFromRecordString(String inputRecord) {
        return inputRecord.substring(inputRecord.indexOf(COMA) + 1, inputRecord.lastIndexOf(COMA));
    }

    private int getAmountFromRecordString(String inputRecord) {
        return Integer.parseInt(inputRecord.substring(inputRecord.lastIndexOf(COMA) + 1));
    }
}
