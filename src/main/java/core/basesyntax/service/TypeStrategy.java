package core.basesyntax.service;

import core.basesyntax.model.FruitDto;

public interface TypeStrategy {
    TypeHandler getTypeHandler(FruitDto fruitDto);
}
