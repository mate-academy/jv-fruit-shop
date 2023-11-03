package core.basesyntax;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (Storage.shopStorage.containsKey(fruitName)) {
            Integer currentQuantity = Storage.shopStorage.get(fruitName);
            Storage.shopStorage.put(fruitName, currentQuantity + transactionQuantity);
        } else {
            Storage.shopStorage.put(fruitName, transactionQuantity);
        }
    }
}
