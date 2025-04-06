package core.basesyntax.operation.handler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.storage.Storage;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getAmount());
    }
}
