package fruit.shop.records.parser;

import fruit.shop.strategy.ActivityStrategy;
import fruit.shop.strategy.ActivityStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordsSaverCommaSeparated implements RecordsSaver {
    public static final String COMMA = ",";
    public static final int FRUIT_INDEX = 1;

    @Override
    public Map<String, Integer> saveRecordsToMap(List<String> records) {
        Map<String, Integer> report = new HashMap<>();
        for (String r : records) {
            String[] options = r.split(COMMA);
            ActivityStrategy activityStrategy = new ActivityStrategyImpl();
            int value;
            if (report.containsKey(options[0])) {
                value = activityStrategy.setValueAccordingToOption(options[0], report.get(options[FRUIT_INDEX]), Integer.parseInt(options[2]));
            } else {
                value = activityStrategy.setValueAccordingToOption(options[0], 0, Integer.parseInt(options[2]));
            }
            report.put(options[FRUIT_INDEX], value);
        }

        return report;
    }
}
