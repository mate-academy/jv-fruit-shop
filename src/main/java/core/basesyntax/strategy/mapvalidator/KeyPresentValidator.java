package core.basesyntax.strategy.mapvalidator;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;

import java.util.Map;

public interface KeyPresentValidator extends MapValidator {
    @Override
    default void validateMap(Map<String, Integer> fruitQuantityMap,
                                    FruitTransaction transaction) {
        if (!fruitQuantityMap.containsKey(transaction.getFruit())) {
            String exceptionMessage = "Fruit from transaction = ["
                    + transaction + "] was not found in map as it is required by "
                    + transaction.getOperation() + " operation";
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
