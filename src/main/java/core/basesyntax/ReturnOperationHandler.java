package core.basesyntax;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (!Storage.shopStorage.containsKey(fruitName)) {
            Storage.shopStorage.put(fruitName, fruitTransaction.getQuantity());
        } else {
            Integer currentQuantity = Storage.shopStorage.get(fruitName);
            Storage.shopStorage.put(fruitName, currentQuantity + transactionQuantity);
        }
    }
}
