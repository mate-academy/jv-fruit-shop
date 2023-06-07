package fruit.shop.records.parser;

import fruit.shop.strategy.ActivityStrategy;
import fruit.shop.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordsSaverCommaSeparated implements RecordsSaver {
    public static final String COMMA = ",";
    public static final int FRUIT_INDEX = 1;
    public static final int OPTION_INDEX = 0;
    public static final int VALUE_INDEX = 2;
    public static final int DEFAULT_VALUE = 0;

    @Override
    public Map<String, Integer> saveRecordsToMap(List<String> records) {
        Map<String, Integer> report = new HashMap<>();
        for (String r : records) {
            String[] options = r.split(COMMA);
            ActivityStrategy activityStrategy = new ActivityStrategyImpl();
            int value;
            if (report.containsKey(options[1])) {
                value = activityStrategy.setValueAccordingToOption(options[OPTION_INDEX],
                        report.get(options[FRUIT_INDEX]), Integer.parseInt(options[VALUE_INDEX]));
            } else {
                value = activityStrategy.setValueAccordingToOption(options[OPTION_INDEX],
                        DEFAULT_VALUE, Integer.parseInt(options[VALUE_INDEX]));
            }
            report.put(options[FRUIT_INDEX], value);
        }
        return report;
    }
}
