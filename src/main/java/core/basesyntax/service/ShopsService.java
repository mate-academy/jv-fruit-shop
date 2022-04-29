package core.basesyntax.service;

import core.basesyntax.model.FruitOperationDto;
import java.util.List;

public interface ShopsService {
    void updateStorage(List<FruitOperationDto> dtos);
}
