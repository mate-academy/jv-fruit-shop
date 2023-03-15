package core.basesyntax.strategy.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class SaveStrategySupply
        implements SaveStrategy<FruitTransaction, DaoService<String, Integer>> {
    @Override
    public void save(FruitTransaction value, DaoService<String, Integer> storage) {
        storage.update(value.getFruit(), storage.getByKey(value.getFruit()) + value.getQuantity());
    }
}
