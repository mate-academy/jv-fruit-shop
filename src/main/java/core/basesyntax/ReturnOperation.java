package core.basesyntax;

import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int updatedQuantity = Storage.get(fruit) + transaction.getQuantity();
        Storage.put(fruit, updatedQuantity);
    }
}
