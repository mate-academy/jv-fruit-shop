package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface FruitService {
    void applyOperationsOnFruitsDto(List<FruitDto> transactions);
}
