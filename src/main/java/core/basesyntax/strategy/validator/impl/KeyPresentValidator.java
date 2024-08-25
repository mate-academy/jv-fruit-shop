package core.basesyntax.strategy.validator.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class KeyPresentValidator implements MapValidator {
    @Override
    public void validateMap(Map<String, Integer> fruitQuantityMap,
                                    FruitTransaction transaction) {
        if (!fruitQuantityMap.containsKey(transaction.getFruit())) {
            String exceptionMessage = "Fruit from transaction = ["
                    + transaction + "] was not found in map as it is required by "
                    + transaction.getOperation() + " operation";
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
