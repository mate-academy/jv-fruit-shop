package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ApplyStrategy {
    public void process(FruitTransaction fruit);
}
