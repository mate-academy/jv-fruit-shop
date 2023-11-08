package core.basesyntax.service.calculator;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.operation.FruitOperation;

public class PurchaseCalculatorImpl implements OperationCalculator {

    @Override
    public void handle(FruitOperation fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int currentQuantity = StorageDao.FRUIT_KINDS_AND_QUANTITY.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - quantity;

        if (newQuantity < 0) {
            throw new RuntimeException("Balance for " + fruit + " is negative");
        }

        StorageDao.FRUIT_KINDS_AND_QUANTITY.put(fruit, newQuantity);
    }
}
