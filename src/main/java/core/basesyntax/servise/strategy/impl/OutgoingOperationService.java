package core.basesyntax.servise.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;

public class OutgoingOperationService implements OperationService {
    @Override
    public void calculation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int newQuantity = Storage.balance.get(fruit) - fruitTransaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Incorrect operation, not enough product: " + fruit);
        }
        Storage.balance.put(fruit, newQuantity);
    }
}
