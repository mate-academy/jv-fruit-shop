package core.basesyntax.strategy;

import core.basesyntax.FruitDto;

public interface FruitTransaction {
    void apply(FruitDto fruitDto);
}
