package core.basesyntax.service.impl;

import core.basesyntax.db.DaoService;
import core.basesyntax.model.FruitTransaction;

public class StrategyApplier {
    private final StrategySelector selector;

    public StrategyApplier(StrategySelector selector) {
        this.selector = selector;
    }

    public void applyAll(Iterable<FruitTransaction> transactions,
                         DaoService<String, Integer> daoService) {
        for (FruitTransaction transaction : transactions) {
            selector.selectStrategy(transaction.getOperation()).save(transaction, daoService);
        }
    }
}
