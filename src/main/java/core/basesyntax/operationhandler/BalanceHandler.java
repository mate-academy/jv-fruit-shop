package core.basesyntax.operationhandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        System.out.println("Current balance:");
        for (String fruit : Storage.fruits.keySet()) {
            System.out.println(fruit + ": " + Storage.fruits.get(fruit));
        }
    }
}
