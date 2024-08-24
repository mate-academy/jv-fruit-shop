package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.mapvalidator.KeyPresentValidator;

import java.util.Map;

public class PurchaseOperationHandler
        extends AbstractOperationHandler
        implements KeyPresentValidator {
    public PurchaseOperationHandler() {
        super(Operation.PURCHASE);
    }

    @Override
    protected void processTransaction(Map<String, Integer> fruitQuantityMap,
                                      FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        validateMap(fruitQuantityMap, transaction);
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
