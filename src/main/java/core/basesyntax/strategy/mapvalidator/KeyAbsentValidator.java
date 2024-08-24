package core.basesyntax.strategy.mapvalidator;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface KeyAbsentValidator extends MapValidator {
    @Override
    default void validateMap(Map<String, Integer> fruitQuantityMap,
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
