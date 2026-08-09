package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyTransaction implements ITransaction {
    @Override
    public void execute(FruitTransaction transaction, Storage storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        storage.addFruit(fruit, quantity);
    }
}
