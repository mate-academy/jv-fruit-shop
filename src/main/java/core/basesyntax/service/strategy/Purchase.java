package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;

import java.util.List;
import java.util.Map;

public class Purchase implements Activities {

    @Override
    public Map<FruitType, Integer> calculateBalanceAfterActivities(List<FruitInfo> fruitServiceList,
                                                                   Map<FruitType, Integer> fruitServiceMap) {
        Map<FruitType, Integer> map = fruitServiceMap;
        for (FruitInfo fruitInfo : fruitServiceList) {
            if (fruitInfo.getActivities().equals("p")) {
                int check = map.get(fruitInfo.getFruitType());
                check -= fruitInfo.getQuantity();
                map.replace(fruitInfo.getFruitType(), check);
            }
        }
        return map;
    }
}
