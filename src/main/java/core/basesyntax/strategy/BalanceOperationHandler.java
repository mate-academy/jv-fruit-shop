package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void calculateFruitQuantity(String fruit, Integer newQuantity) {
        Storage.getFruits().put(fruit, newQuantity);
    }
}
