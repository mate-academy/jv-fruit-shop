package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> getAvailableFruits(List<FruitDto> fruitDtos);
}
