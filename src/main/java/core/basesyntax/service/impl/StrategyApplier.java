package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;

public class StrategyApplier {
    private final StrategySelector selector;

    public StrategyApplier(StrategySelector selector) {
        this.selector = selector;
    }

    public void applyAll(Iterable<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            selector.selectStrategy(transaction.getOperation()).save(transaction);
        }
    }
}
