package core.basesyntax.service;

import java.util.Map;

public class StoreServiceImpl implements StoreService {
    private static final String COLUMN_NAMES = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruitsStorage) {
        StringBuilder stringBuilder = new StringBuilder(COLUMN_NAMES);
        for (Map.Entry<String, Integer> fruits : fruitsStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruits.getKey())
                    .append(",")
                    .append(fruits.getValue());
        }
        return stringBuilder.toString();
    }
}
