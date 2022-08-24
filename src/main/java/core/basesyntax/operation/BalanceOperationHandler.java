package core.basesyntax.operation;

import core.basesyntax.DataBase;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processingOperation(String fruit, int quantity) {
        DataBase.fruitsAmount.put(fruit, quantity);
    }
}
