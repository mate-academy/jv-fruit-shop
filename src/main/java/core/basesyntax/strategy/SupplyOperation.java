package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer currentSupply = Storage.getFruit(transaction.getFruit());
        Storage.putFruit(transaction.getFruit(), currentSupply + transaction.getQuantity());
    }
}
