package core.basesyntax.storage.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.FruitDao;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final Database<Fruit> db;

    public FruitDaoImpl() {
        db = new Database<>();
    }

    @Override
    public Map<Fruit, Integer> getBalance() {
        return db.getBalance();
    }

    @Override
    public int getAmount(Fruit fruit) {
        return db.getAmount(fruit);
    }

    @Override
    public void updateBalance(Fruit fruit, int amount) {
        db.updateBalance(fruit, amount);
    }
}
