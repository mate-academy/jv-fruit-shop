package core.basesyntax.servise.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;

public class OutgoingOperationService implements OperationService {
    private final FruitTransaction fruitTransaction;

    public OutgoingOperationService(FruitTransaction fruitTransaction) {
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void calculation() {
        String fruit = fruitTransaction.getFruit();
        int newQuantity = Storage.balance.get(fruit) - fruitTransaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Incorrect operation, not enough product: " + fruit);
        }
        Storage.balance.put(fruit, newQuantity);
    }
}
