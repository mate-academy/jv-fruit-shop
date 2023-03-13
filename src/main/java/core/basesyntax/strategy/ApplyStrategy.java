package core.basesyntax.strategy;

import core.basesyntax.model.FruitNegotiation;

public interface ApplyStrategy {
    public void process(FruitNegotiation fruit);
}
