package core.basesyntax.db;

import java.util.Map;

public class Storage {
    private static final String DEFAULT_STRING = "fruit,quantity";
    private static final String COMMA = ",";

    private final Map<String, Integer> storage;

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public int getFruitQuantity(String fruitName) {
        return storage.getOrDefault(fruitName, 0);
    }

    public boolean findFruit(String fruitName) {
        return storage.containsKey(fruitName);
    }

    public void addFruit(String fruitName, int quantity) {
        storage.put(fruitName, quantity);
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append(DEFAULT_STRING).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
