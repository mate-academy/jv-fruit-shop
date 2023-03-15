package core.basesyntax.strategy.impl;

import core.basesyntax.db.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class TransactionStrategyBalance implements SaveStrategy<FruitTransaction, Dao<String, Integer>> {
    @Override
    public void save(FruitTransaction value, Dao<String, Integer> storage) {
        storage.create(value.getFruit(), value.getQuantity());
    }
}
