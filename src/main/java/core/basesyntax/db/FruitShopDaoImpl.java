package core.basesyntax.db;

import core.basesyntax.storage.Storage;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDao {
    private static int ZERO = 0;

    @Override
    public int getStorageSize() {
        return Storage.fruitStorage.size();
    }

    @Override
    public List<String> getAllFruitsWithQuantities() {
        List<String> lines = new ArrayList<>();
        for (String key : Storage.fruitStorage.keySet()) {
            Integer value = Storage.fruitStorage.get(key);
            lines.add(key + ", " + value);
        }
        return lines;
    }

    @Override
    public void addFruitAndQuantity(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public void addFruitWithoutQuantity(String fruit) {
        Storage.fruitStorage.put(fruit, ZERO);
    }
}
