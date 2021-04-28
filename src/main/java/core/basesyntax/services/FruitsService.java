package core.basesyntax.services;

import core.basesyntax.dto.Dto;
import core.basesyntax.storage.FruitDataBase;

public interface FruitsService {
    int change(Dto fruitDto, FruitDataBase fruitDataBase);
}
