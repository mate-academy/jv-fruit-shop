package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfFruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartingBalanceImpl implements StartingBalance {
    @Override
    public Map<TypeOfFruit, Integer> getStartingBalance(List<FruitTransaction> fruitServiceList) {
        Map<TypeOfFruit, Integer> map = new HashMap<>();
        for (FruitTransaction fruitInfo : fruitServiceList) {
            if (fruitInfo.getOperation().equals(Operation.BALANCE)) {
                map.put(fruitInfo.getTypeOfFruit(), fruitInfo.getQuantity());
            }
        }
        return map;
    }
}
