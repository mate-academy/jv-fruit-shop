package core.basesyntax.service;

import core.basesyntax.model.dto.FruitDataDto;
import java.util.List;

public interface FruitService {
    void applyOperationsOnFruitsDto(List<FruitDataDto> fruitDataDtoList);

    String generateReport();
}
