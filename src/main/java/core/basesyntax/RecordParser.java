package core.basesyntax;

import core.basesyntax.activity.ActivityTypes;

import java.util.ArrayList;
import java.util.List;

public class RecordParser {
    private final static int OPERATION_INDEX = 0;
   List<Record> parseRecords(String records) {
        String[] recordsAsStringArray = records.split("\n");
        List<Record> recordList = new ArrayList<>();
        for (String record : recordsAsStringArray) {
            String activity = getActivityFromRecordString(record);
            String fruitName = getFruitNameFromRecordString(record);
            int amount = getAmountFromRecordString(record);
            Record localRecord = new Record();
            localRecord.setActivity(activity);
            localRecord.setFruit(fruitName);
            localRecord.setAmount(amount);
            recordList.add(localRecord);
        }
        return recordList;
    }

    String getActivityFromRecordString(String inputRecord) {
       return String.valueOf(inputRecord.charAt(OPERATION_INDEX));
    }

    String getFruitNameFromRecordString(String inputRecord) {
       return inputRecord.substring(inputRecord.indexOf(",") + 1, inputRecord.lastIndexOf(","));
    }

    int getAmountFromRecordString(String inputRecord) {
       return Integer.parseInt(inputRecord.substring(inputRecord.lastIndexOf(",") + 1));
    }
}
