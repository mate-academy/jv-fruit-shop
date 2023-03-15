package core.basesyntax.strategy.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class SaveStrategyBalance implements SaveStrategy<FruitTransaction> {

    private final DaoService storage;

    public SaveStrategyBalance(DaoService storage) {
        this.storage = storage;
    }

    @Override
    public void save(FruitTransaction value) {
        storage.create(value.getFruit(), value.getQuantity());
    }
}
