package core.basesyntax.operationHandler;

import core.basesyntax.FruitStore;
import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;

public class BalanceHandler implements OperationHandler{
    @Override
    public void handleOperation(FruitStore fruitStore, FruitTransaction transaction, Operation operation) {
        fruitStore.balanceFruit();
    }
}
