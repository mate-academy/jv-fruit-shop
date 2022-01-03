package core.basesyntax.services;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface FruitService {
    String makeReport();

    void applyOperationsOnFruitsDto(List<FruitDto> fruitDtos);
}
