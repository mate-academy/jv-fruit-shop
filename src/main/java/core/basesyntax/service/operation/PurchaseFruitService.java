package core.basesyntax.service.operation;

import core.basesyntax.service.model.FruitTransaction;

public class PurchaseFruitService implements FruitService {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int balance = storage.storage.get(fruitTransaction.getFruit());
        storage.storage.put(fruitTransaction.getFruit(), balance - fruitTransaction.getValue());
    }

}
