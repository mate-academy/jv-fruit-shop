package core.basesyntax.strategy.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class SaveStrategyBalance implements
        SaveStrategy<FruitTransaction, DaoService<String, Integer>> {
    @Override
    public void save(FruitTransaction value, DaoService<String, Integer> storage) {
        storage.create(value.getFruit(), value.getQuantity());
    }
}
