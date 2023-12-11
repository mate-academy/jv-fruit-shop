package core.basesyntax.operationHandler;

import core.basesyntax.FruitStore;
import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;

public class ReturnHandler implements OperationHandler{

    @Override
    public void handleOperation(FruitStore fruitStore, FruitTransaction transaction, Operation operation) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        fruitStore.returnFruit(fruit, quantity);
    }
}
