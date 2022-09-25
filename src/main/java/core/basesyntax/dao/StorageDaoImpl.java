package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private static final Integer DEFAULT_COUNT = 0;

    @Override
    public void update(String fruit, Integer count) {
        Storage.fruitsStorage.put(fruit, count);
    }

    @Override
    public boolean checkFruit(String fruit) {
        return Storage.fruitsStorage.containsKey(fruit);
    }

    @Override
    public void createFruit(String fruit) {
        Storage.fruitsStorage.put(fruit,DEFAULT_COUNT);
    }

    @Override
    public Integer getCountFruit(String fruit) {
        if (!checkFruit(fruit)) {
            createFruit(fruit);
        }
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
     public String getAllFruitsFromStorage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
