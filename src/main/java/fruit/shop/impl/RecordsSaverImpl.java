package fruit.shop.impl;

import fruit.shop.service.saver.RecordsSaver;
import fruit.shop.service.strategy.ActivityStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordsSaverImpl implements RecordsSaver {
    public static final int FRUIT_INDEX = 1;
    public static final int OPTION_INDEX = 0;
    public static final int VALUE_INDEX = 2;
    public static final int DEFAULT_VALUE = 0;

    @Override
    public Map<String, Integer> saveRecordsToMap(List<String[]> parsedRecords) {
        Map<String, Integer> report = new HashMap<>();
        ActivityStrategy activityStrategy = new ActivityStrategyImpl();
        for (String[] options : parsedRecords) {
            int value;
            if (report.containsKey(options[FRUIT_INDEX])) {
                value = activityStrategy.handleTransaction(options[OPTION_INDEX],
                        report.get(options[FRUIT_INDEX]), Integer.parseInt(options[VALUE_INDEX]));
            } else {
                value = activityStrategy.handleTransaction(options[OPTION_INDEX],
                        DEFAULT_VALUE, Integer.parseInt(options[VALUE_INDEX]));
            }
            report.put(options[FRUIT_INDEX], value);
        }
        return report;
    }
}
