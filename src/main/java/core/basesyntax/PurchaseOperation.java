package core.basesyntax;

import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.get(fruit);
        int result = current - transaction.getQuantity();
        if (result < 0) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock");
        }
        Storage.put(fruit, result);
    }
}
