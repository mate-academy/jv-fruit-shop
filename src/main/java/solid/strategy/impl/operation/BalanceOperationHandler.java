package solid.strategy.impl.operation;

import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strorage.FruitStorage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        FruitStorage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
