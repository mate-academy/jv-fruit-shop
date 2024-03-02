package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;
import java.util.List;
import java.util.Map;

public interface Activities {
    Map<FruitType, Integer> calculateBalanceAfterActivities(
            List<FruitInfo> fruitServiceList,
            Map<FruitType, Integer> fruitServiceMap);
}
