package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.exception.InvalidOperatioExeption;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class PurchaseOperation implements OperationProcessor {
    private StorageImpl storageImpl;

    public PurchaseOperation(StorageImpl storageImpl) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        int currentQuantity = storageImpl.calculateAmount(fruitTransaction);
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new InvalidOperatioExeption("Not enough product in stock now. In stock: "
                    + currentQuantity
                    + ", but your need: " + fruitTransaction.getQuantity());
        }
        int newQuantity = currentQuantity - fruitTransaction.getQuantity();
        storageImpl.update(fruitTransaction, newQuantity);
    }
}
