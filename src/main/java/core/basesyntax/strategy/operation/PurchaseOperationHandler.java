package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitOperation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(FruitOperation fruitOperation, int value) {
        int prev = fruitOperation.getQuantity();

        if (value > prev) {
            throw new IllegalArgumentException("Cannot purchase more than "
                    + "available in stock. Requested: "
                    + value + ", Available: " + prev);
        }

        int newQuantity = prev - value;
        fruitOperation.setQuantity(newQuantity);
        return newQuantity;
    }
}
