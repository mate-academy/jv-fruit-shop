package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());

        if (currentQuantity == null) {
            throw new IllegalArgumentException("Fruit does not exist in storage.");
        }
        if (currentQuantity < 0) {
            throw new IllegalArgumentException("Invalid quantity for purchase.");
        }
        int purchaseQuantity = transaction.getQuantity();
        int newQuantity = currentQuantity - purchaseQuantity;

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Resulting quantity cannot be negative for fruit: "
                    + transaction);
        }
        Storage.storage.put(transaction.getFruit(), newQuantity);
    }
}

