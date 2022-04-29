package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer initialQuantity = Storage.fruitStorage.get(fruitTransaction.getFruit());
        if (Storage.fruitStorage.get(fruitTransaction.getFruit()) == null) {
            throw new RuntimeException("We don't have fruit");
        }
        if (initialQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There is no such amount of fruits in storage");
        }
        Storage.fruitStorage.replace(fruitTransaction.getFruit(),
                initialQuantity - fruitTransaction.getQuantity());
    }
}
