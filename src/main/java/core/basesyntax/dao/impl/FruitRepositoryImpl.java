package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.db.Database;
import java.util.Map;

public class FruitRepositoryImpl implements FruitRepository {
    private final Map<String, Integer> db = Database.getStorage();

    @Override
    public void add(String fruit, int quantity) {
        Integer newQuantity = db.containsKey(fruit)
                ? db.get(fruit) + quantity
                : quantity;
        db.put(fruit, newQuantity);
    }

    @Override
    public void remove(String fruit, int quantity) {
        if (db.get(fruit) - quantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage to remove");
        }
        db.put(fruit, db.get(fruit) - quantity);
    }

    @Override
    public boolean hasFruit(String fruit) {
        return db.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Map.copyOf(db);
    }
}
