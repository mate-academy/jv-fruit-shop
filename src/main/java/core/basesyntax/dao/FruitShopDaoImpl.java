package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    private static final String HEADLINE = "fruit,quantity";
    private static final int HEADLINE_INDEX = 0;
    private static final int FIRST_LINE_REPORT = 1;

    @Override
    public void addToStorage(String key, Integer value) {
        Storage.fruits.put(key, value);
    }

    @Override
    public void addValue(String key, Integer value) {
        Integer newValue = Storage.fruits.get(key) + value;
        Storage.fruits.put(key, newValue);
    }

    @Override
    public void subtractValue(String key, Integer value) {
        Integer newValue = Storage.fruits.get(key) - value;
        Storage.fruits.put(key, newValue);
    }

    @Override
    public String[] getReport() {
        String[] report = new String[Storage.fruits.size() + 1];
        report[HEADLINE_INDEX] = HEADLINE;
        int counter = FIRST_LINE_REPORT;
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report[counter++] = entry.getKey() + "," + entry.getValue();
        }
        return report;
    }
}
