package core.basesyntax.service.calculator;

import core.basesyntax.db.Storage;
import core.basesyntax.service.operation.FruitOperation;

public class PurchaseCalculatorImpl implements OperationCalculator {

    @Override
    public void handle(FruitOperation fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.getFruitKindsAndQuantity().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - quantity;

        if (newQuantity < 0) {
            throw new RuntimeException("Balance for " + fruit + " is negative");
        }

        Storage.getFruitKindsAndQuantity().put(fruit, newQuantity);
    }
}

