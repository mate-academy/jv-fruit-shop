package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    private Storage storage = new Storage();

    @Override
    public void add(String fruit, int quantity) {
        storage.addToReport(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return storage.getQuantity(fruit);
    }
}
