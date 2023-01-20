package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void calculateFruitQuantity(String fruit, Integer newQuantity) {
        Storage.getFruits().replace(fruit, Storage.getFruits().get(fruit),
                Storage.getFruits().get(fruit) - newQuantity);
    }
}
