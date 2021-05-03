package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    boolean applySuitableOperation(List<FruitRecordDto> fruitRecordDtos);

    Map<Fruit, Integer> fruitStorage();
}
