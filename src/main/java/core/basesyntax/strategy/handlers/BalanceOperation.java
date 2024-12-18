package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        checkIfTransactionDataIsValid(fruit, quantity);
        FruitStorage.fruits.put(fruit, quantity);
    }
}
