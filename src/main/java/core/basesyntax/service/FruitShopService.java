package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface FruitShopService {
    void updateStorage(List<FruitRecordDto> fruitRecordDtos);
}
