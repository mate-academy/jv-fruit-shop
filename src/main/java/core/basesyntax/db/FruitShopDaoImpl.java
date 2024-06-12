package core.basesyntax.db;

import core.basesyntax.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDao{
    @Override
    public int storageSize() {
        return Storage.fruitStorage.size();
    }

    @Override
    public List<String> getKeyAndValue() {
        List<String> lines = new ArrayList<>();
        for (String key : Storage.fruitStorage.keySet()) {
            Integer value = Storage.fruitStorage.get(key);
            lines.add(key + ", " + value);
        }
        return lines;
    }

    @Override
    public void put(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public void putOnlyFruits(String fruit) {
        Storage.fruitStorage.put(fruit, null);
    }
}
