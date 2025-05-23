package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitOperation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(FruitOperation fruitOperation, int value) {
        int newQuantity = fruitOperation.getQuantity() + value;
        fruitOperation.setQuantity(newQuantity);
        return newQuantity;
    }
}
