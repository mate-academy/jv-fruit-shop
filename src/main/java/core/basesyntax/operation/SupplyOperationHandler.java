package core.basesyntax.operation;

import core.basesyntax.DataBase;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processingOperation(String fruit, int quantity) {
        Integer amount = DataBase.fruitsAmount.get(fruit) + quantity;
        DataBase.fruitsAmount.put(fruit, amount);
    }
}
