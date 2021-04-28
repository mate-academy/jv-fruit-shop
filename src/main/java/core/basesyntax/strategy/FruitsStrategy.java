package core.basesyntax.strategy;

import core.basesyntax.dto.Dto;
import core.basesyntax.storage.FruitDataBase;

public interface FruitsStrategy {
    int change(Dto fruitDto, FruitDataBase fruitDataBase);
}
