package core.basesyntax.serviceimpl;

import core.basesyntax.service.Strategy;

public class CalculateOperationsImpl {
    private Strategy strategy;

    public CalculateOperationsImpl(Strategy strategy) {
        this.strategy = strategy;
    }
}
