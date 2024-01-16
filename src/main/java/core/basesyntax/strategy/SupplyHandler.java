package core.basesyntax.strategy;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import core.basesyntax.storage.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        fruitStorage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
