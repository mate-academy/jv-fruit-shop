package strategy;

import db.FruitStorage;
import java.util.Map;

public class FruitStorageHandler implements StorageHandler<String,Integer> {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final FruitStorage FRUIT_STORAGE = new FruitStorage();

    @Override
    public void put(String fruit, Integer value) {
        FRUIT_STORAGE.getFruits().put(fruit, value);
    }

    @Override
    public boolean remove(String fruit, Integer count) {
        return FRUIT_STORAGE.getFruits().remove(fruit, count);
    }

    @Override
    public Integer getValue(String fruit) {
        return FRUIT_STORAGE.getFruits().get(fruit);
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEAD);
        for (Map.Entry entry : FRUIT_STORAGE.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
