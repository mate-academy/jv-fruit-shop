package core.basesyntax.strategy.impl;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, ShopStorage storage) {
        int newQuantity =
                storage.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity();
        storage.update(transaction.getFruit(), newQuantity);
    }
}
