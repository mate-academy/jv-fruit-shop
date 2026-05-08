package strategy;

import db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        int fruitFromStorage = Storage.getInstance().getFruitStorage().getOrDefault(fruit, 0);
        Storage.getInstance().getFruitStorage().put(fruit, fruitFromStorage + quantity);
    }
}
