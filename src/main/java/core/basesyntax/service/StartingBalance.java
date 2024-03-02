package core.basesyntax.service;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;

import java.util.List;
import java.util.Map;

public interface StartingBalance {

    Map<FruitType, Integer> getStartingBalance(List<FruitInfo> fruitServiceList);
}
