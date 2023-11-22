package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitStockDaoImpl implements FruitStockDao {
    private final Storage storage;

    public FruitStockDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(String fruit, Integer quantity) {
        storage.getFruitStorage().remove(fruit);
        storage.getFruitStorage().put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getFruitStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(fruit))
                .map(java.util.Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Fruit " + fruit
                        + " record not found"));
    }
}
