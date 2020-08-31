package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public interface FruitMapper {
    Fruit parse(FruitDto data);
}
