package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void makeOperationsOnFruitsDto(List<FruitDto> fruitDtos);

    Map<String, Long> gerFruitReport();
}
