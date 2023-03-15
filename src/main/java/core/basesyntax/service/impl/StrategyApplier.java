package core.basesyntax.service.impl;

import core.basesyntax.db.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SaveStrategy;

public class StrategyApplier {
    private final StrategySelector selector;

    public StrategyApplier(StrategySelector selector) {
        this.selector = selector;
    }

    public void apply(SaveStrategy<Dao<String, Integer>, FruitTransaction> strategy,
                      FruitTransaction transaction,
                      Dao<String, Integer> dao) {
        strategy.save(dao, transaction);
    }

    public void applyAll(Iterable<FruitTransaction> transactions,
                         Dao<String, Integer> dao) {
        for (FruitTransaction transaction : transactions) {
            selector.selectStrategy(transaction.getOperation()).save(transaction, dao);
        }
    }
}
