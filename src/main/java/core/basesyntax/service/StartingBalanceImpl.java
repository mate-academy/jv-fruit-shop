package core.basesyntax.service;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartingBalanceImpl implements StartingBalance {

    @Override
    public Map<FruitType, Integer> getStartingBalance(List<FruitInfo> fruitServiceList) {
        Map<FruitType, Integer> map = new HashMap<>();
        for (FruitInfo fruitInfo : fruitServiceList) {
            if (fruitInfo.getActivities().equals("b")) {
                map.put(fruitInfo.getFruitType(), fruitInfo.getQuantity());
            }
        }
        return map;
    }
}
