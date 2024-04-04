package core.basesyntax.service;

import core.basesyntax.database.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitsCalculator {
    Map<String, Integer> applyQuantity(List<FruitTransaction> list);

    List<FruitTransaction> parseData(List<String> data);
}
