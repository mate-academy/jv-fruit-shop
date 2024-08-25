package core.basesyntax.strategy.validator;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface MapValidator {
    void validateMap(Map<String, Integer> fruitQuantityMap,
                     FruitTransaction transaction);
}
