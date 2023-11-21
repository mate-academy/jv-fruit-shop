package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitStockDaoImpl implements FruitStockDao {
    private Storage storage;

    public FruitStockDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void add(Map.Entry<String, Integer> entry) {
        storage.getFruitStorage().put(entry.getKey(), entry.getValue());
    }

    @Override
    public Map.Entry<String, Integer> get(String fruit) {
        return storage.getFruitStorage().entrySet().stream()
                .filter(e -> e.getKey().equals(fruit))
                .findFirst().orElseThrow(() -> new RuntimeException(
                "Fruit " + fruit + " record not" + " found"));
    }

    @Override
    public void update(Map.Entry<String, Integer> entry) {
        storage.getFruitStorage().replace(entry.getKey(), entry.getValue());
    }
}
