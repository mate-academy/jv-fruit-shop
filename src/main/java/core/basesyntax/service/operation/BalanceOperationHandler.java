package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getName(), fruitTransaction.getQuantity());
        Storage.fruits.put(fruitTransaction.getName(), fruit);
    }
}
