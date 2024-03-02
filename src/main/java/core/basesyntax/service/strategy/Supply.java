package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;
import java.util.List;
import java.util.Map;

public class Supply implements Activities {

    @Override
    public Map<FruitType, Integer> calculateBalanceAfterActivities(
            List<FruitInfo> fruitServiceList,
            Map<FruitType, Integer> fruitServiceMap) {
        for (FruitInfo fruitInfo : fruitServiceList) {
            if (fruitInfo.getActivities().equals("s")) {
                int check = fruitServiceMap.get(fruitInfo.getFruitType());
                check += fruitInfo.getQuantity();
                fruitServiceMap.replace(fruitInfo.getFruitType(), check);
            }
        }
        return fruitServiceMap;
    }
}
