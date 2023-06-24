package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface UnaryOperation {
    public void apply(FruitTransaction fruit);
}
