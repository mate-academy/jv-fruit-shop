package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public interface FruitParser {
    Fruit parse(FruitDto data);
}
