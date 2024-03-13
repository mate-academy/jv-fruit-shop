package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeOfFruit;
import java.util.List;
import java.util.Map;

public interface StartingBalance {
    Map<TypeOfFruit, Integer> getStartingBalance(List<FruitTransaction> fruitServiceList);
}
