package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.QuantityIncrementer;
import java.util.Map;
import java.util.function.BiFunction;

public class QuantityIncrementerImpl implements QuantityIncrementer {
    @Override
    public void incrementByQuantity(Map<String, Integer> fruitQuantityMap,
                                     FruitTransaction transaction) {
        BiFunction<String, Integer, Integer> incrementFruitQuantityFunction =
                (fruitName, quantity) -> quantity + transaction.getQuantity();
        fruitQuantityMap.computeIfPresent(transaction.getFruit(), incrementFruitQuantityFunction);
    }
}
