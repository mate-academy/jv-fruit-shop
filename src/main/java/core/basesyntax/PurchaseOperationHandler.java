package core.basesyntax;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (Storage.shopStorage.containsKey(fruitName)) {
            Integer availableQuantity = Storage.shopStorage.get(fruitName);
            if (availableQuantity < transactionQuantity) {
                throw new RuntimeException("You have less product than you are trying to buy! " + fruitName);
            } else {
                Storage.shopStorage.put(fruitName, availableQuantity - transactionQuantity);
            }
        } else {
            throw new RuntimeException("You don't have such fruits!");
        }
    }
}
