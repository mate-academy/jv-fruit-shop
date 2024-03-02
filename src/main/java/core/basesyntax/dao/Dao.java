package core.basesyntax.dao;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;
import java.util.List;
import java.util.Map;

public interface Dao {
    void transferToBalance(Map<FruitType, Integer> map);

    Map<FruitType, Integer> getInfoFromBalance();

    void transferToAllFruit(List<FruitInfo> fruitList);

    List<FruitInfo> getInfoFromAllFruit();
}
