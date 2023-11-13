package core.basesyntax.strategy.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class SaveStrategySupply implements SaveStrategy<FruitTransaction> {

    private final DaoService storage;

    public SaveStrategySupply(DaoService storage) {
        this.storage = storage;
    }

    @Override
    public void save(FruitTransaction value) {
        storage.update(value.getFruit(),
                (int) storage.getByKey(value.getFruit()) + value.getQuantity());
    }
}
