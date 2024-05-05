package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitDaoTransaction {

    void updateAmount(FruitTransaction fruitTransaction);

    Map<String, Integer> getFruitMap();
}
