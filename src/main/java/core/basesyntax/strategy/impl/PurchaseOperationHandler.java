package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class PurchaseOperationHandler extends AbstractOperationHandler {
    public PurchaseOperationHandler(MapValidator mapValidator) {
        super(Operation.PURCHASE, mapValidator);
    }

    @Override
    protected void processTransaction(Map<String, Integer> fruitQuantityMap,
                                      FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newQuantity = fruitQuantityMap.get(fruit) - transaction.getQuantity();
        validateNewQuantity(newQuantity, transaction);
        fruitQuantityMap.put(fruit, newQuantity);
    }

    private static void validateNewQuantity(int newQuantity, FruitTransaction transaction) {
        if (newQuantity < 0) {
            String exceptionMessage = "Transaction = ["
                    + transaction + "] resulted in negative quantity of product";
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
