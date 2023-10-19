package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer initialQuantity = Storage.fruitStorage.get(fruitTransaction.getFruit());
        Storage.fruitStorage.put(fruitTransaction.getFruit(), initialQuantity == null
                ? fruitTransaction.getQuantity() : initialQuantity
                + fruitTransaction.getQuantity());
    }
}
