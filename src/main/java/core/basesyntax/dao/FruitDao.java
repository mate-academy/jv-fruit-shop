package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfFruit;
import java.util.List;
import java.util.Map;

public interface FruitDao {
    void transferStartBalance(Map<TypeOfFruit, Integer> map, List<FruitTransaction> fruitInfoList);

    void rebalanced(Map<TypeOfFruit, Integer> map);

    Map<TypeOfFruit, Integer> getInfoFromBalance();

    List<FruitTransaction> getInfoFromPurchaseOperationFruit();

    List<FruitTransaction> getInfoFromReturnOperationFruit();

    List<FruitTransaction> getInfoFromSupplyOperationFruit();
}
