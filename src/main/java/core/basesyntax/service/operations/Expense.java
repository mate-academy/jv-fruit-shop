package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;

public class Expense implements OperationService {

    @Override
    public void operate(String fruitName, Integer weight) {
        Storage.fruits.replace(fruitName, Storage.fruits.get(fruitName) - weight);
    }
}
