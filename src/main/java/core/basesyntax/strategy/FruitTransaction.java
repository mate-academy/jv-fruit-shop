package core.basesyntax.strategy;

import core.basesyntax.model.FruitDto;

public interface FruitTransaction {
    void apply(FruitDto fruitDto);
}
