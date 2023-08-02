package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void completeOperation(FruitTransaction fruitTransaction) {
        Integer oldQuantity = Storage.storage.get(fruitTransaction.getName());
        isValidQuantityToPurchase(oldQuantity, fruitTransaction.getQuantity());
        Integer newQuantity = oldQuantity - fruitTransaction.getQuantity();

        Storage.storage.put(fruitTransaction.getName(), newQuantity);
    }

    private boolean isValidQuantityToPurchase(Integer currentQuantity, Integer requiredQuantity) {
        if (currentQuantity < requiredQuantity) {
            throw new InvalidOperationException("The required quantity " + requiredQuantity
                    + " can't be sold, since the current quantity "
                    + currentQuantity);

        }
        return true;
    }
}
