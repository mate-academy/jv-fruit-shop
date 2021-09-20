package core.basesyntax.dataservice;

import core.basesyntax.model.FruitType;
import java.util.Map;

public interface FruitAmountCounter {
    Map<FruitType, Integer> countFruitByOperation(String filePathFrom);
}
