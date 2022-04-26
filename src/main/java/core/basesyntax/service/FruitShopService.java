package core.basesyntax.service;

import core.basesyntax.model.FruitOperationDto;
import java.util.List;

public interface FruitShopService {
    void saveToStorage(List<FruitOperationDto> fruitOperationDtoList);

    String createReport();
}
