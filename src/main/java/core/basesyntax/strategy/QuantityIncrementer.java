package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.mapvalidator.KeyPresentValidator;

import java.util.Map;
import java.util.function.BiFunction;

public interface QuantityIncrementer extends KeyPresentValidator {
    default void incrementByQuantity(Map<String, Integer> fruitQuantityMap,
                                     FruitTransaction transaction) {
        validateMap(fruitQuantityMap, transaction);
        BiFunction<String, Integer, Integer> incrementFruitQuantityFunction =
                (fruitName, quantity) -> quantity + transaction.getQuantity();
        fruitQuantityMap.computeIfPresent(transaction.getFruit(), incrementFruitQuantityFunction);
    }
}
