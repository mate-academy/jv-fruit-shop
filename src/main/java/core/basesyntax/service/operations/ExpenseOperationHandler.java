package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;

public class ExpenseOperationHandler implements OperationHandler {

    @Override
    public void operate(String fruitName, Integer weight) {
        Storage.fruits.replace(fruitName, Storage.fruits.get(fruitName) - weight);
    }
}
