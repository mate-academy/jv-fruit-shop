package core.basesyntax.operations;

import core.basesyntax.model.FruitDto;

public interface Operation {
    void apply(FruitDto fruitDto);
}
