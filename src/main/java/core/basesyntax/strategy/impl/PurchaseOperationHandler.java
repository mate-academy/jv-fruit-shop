package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(Map<String, Integer> fruitQuantityMap,
                        FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newQuantity = fruitQuantityMap.get(fruit) - transaction.getQuantity();
        validateNewQuantity(newQuantity, transaction);
        fruitQuantityMap.put(fruit, newQuantity);
    }

    private static void validateNewQuantity(int newQuantity, FruitTransaction transaction) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Transaction = [" + transaction
                    + "] resulted in negative quantity of product");
        }
    }
}
