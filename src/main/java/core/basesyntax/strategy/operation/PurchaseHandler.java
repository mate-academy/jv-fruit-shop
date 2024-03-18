package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int fruitAmount = Storage.fruits.get(fruit);
        int purchaseFruitAmount = transaction.getQuantity();
        if (fruitAmount >= purchaseFruitAmount) {
            Storage.fruits.put(transaction.getFruit(), fruitAmount - purchaseFruitAmount);
        } else {
            throw new RuntimeException(
                    "Impossible operation. Purchase amount = " + purchaseFruitAmount + " " + fruit 
                    + ". Actual amount = " + fruitAmount);
        }
    }
}
