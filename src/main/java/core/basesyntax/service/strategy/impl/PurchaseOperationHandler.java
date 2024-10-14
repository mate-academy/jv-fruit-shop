package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());

        if (currentQuantity == null) {
            throw new IllegalArgumentException("Fruit does not exist in storage.");
        }
        if (currentQuantity < transaction.getQuantity()) {
            throw new IllegalArgumentException(
                    "There isn't enough product in stock. Available quantity: "
                    + currentQuantity
                    + ", Requested quantity: " + transaction.getQuantity());
        }
        int purchaseQuantity = transaction.getQuantity();
        int newQuantity = currentQuantity - purchaseQuantity;

        Storage.storage.put(transaction.getFruit(), newQuantity);
    }
}
