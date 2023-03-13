package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

@FunctionalInterface
public interface ReportStrategy {
    void process(FruitTransaction transaction);
}
