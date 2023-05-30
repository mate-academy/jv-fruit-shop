package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.exception.InvalidOperatioExeption;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class ReturnOperation implements OperationProcessor {
    private StorageImpl storageImpl;

    public ReturnOperation(StorageImpl storageImpl) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        int currentQuantity = storageImpl.calculateAmount(fruitTransaction);
        int newQuantity = currentQuantity + fruitTransaction.getQuantity();
        if (newQuantity < 0) {
            throw new InvalidOperatioExeption("Result can`t be less than 0, but was: "
                    + newQuantity);
        }
        storageImpl.update(fruitTransaction, newQuantity);
    }
}
