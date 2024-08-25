package core.basesyntax.strategy.validator.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class KeyAbsentValidator implements MapValidator {
    @Override
    public void validateMap(Map<String, Integer> fruitQuantityMap,
                                    FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (fruitQuantityMap.containsKey(fruit)) {
            String exceptionMessage = "Fruit from transaction = ["
                    + transaction + "] was already present in the map in quantity of = ["
                    + fruitQuantityMap.get(fruit) + "]";
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
