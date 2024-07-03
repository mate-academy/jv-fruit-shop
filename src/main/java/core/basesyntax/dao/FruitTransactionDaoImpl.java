package core.basesyntax.dao;

import core.basesyntax.db.DataBase;

public class FruitTransactionDaoImpl implements FruitTransactionDao{
    @Override
    public void add(String fruit, int quantity) {
        DataBase.storage.put(fruit, quantity);
    }

    @Override
    public void update(String fruit, int quantity) {
        DataBase.storage.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return DataBase.storage.get(fruit);
    }
}
